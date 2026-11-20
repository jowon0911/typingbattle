package com.example.typingbattle.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.typingbattle.model.GameMessage;
import com.example.typingbattle.model.PlayerResult;
import com.example.typingbattle.model.Room;

@Service
public class GameService {

    public static final long MATCH_START_WAIT_MS = 10000;
    public static final long MATCH_CANCEL_MS = 20000;
    public static final long EMPTY_ROOM_MS = 60000;

    private final RoomService roomService;
    private final RankingService rankingService;
    private final SimpMessagingTemplate messagingTemplate;

    private final Map<String, String> sessionRooms = new ConcurrentHashMap<>();
    private final Map<String, String> sessionNicknames = new ConcurrentHashMap<>();

    public GameService(RoomService roomService, RankingService rankingService,
                       SimpMessagingTemplate messagingTemplate) {
        this.roomService = roomService;
        this.rankingService = rankingService;
        this.messagingTemplate = messagingTemplate;
    }

    public void join(String code, String nickname, String sessionId) {
        Room room = roomService.findRoom(code);
        if (room == null || nickname == null || sessionId == null) {
            return;
        }

        synchronized (room) {
            if (!room.addPlayer(nickname)) {
                GameMessage rejected = new GameMessage();
                rejected.setType("REJECTED");
                rejected.setNickname(nickname);
                send(room, rejected);
                return;
            }
            sessionRooms.put(sessionId, code);
            sessionNicknames.put(sessionId, nickname);

            sendPlayers(room);
            if (room.isMatched() && room.isAllReservedJoined()) {
                startGame(room);
            }
        }
    }

    public void start(String code, String sessionId) {
        Room room = findMyRoom(code, sessionId);
        if (room == null) {
            return;
        }

        synchronized (room) {
            if (room.canStart(sessionNicknames.get(sessionId))) {
                startGame(room);
            }
        }
    }

    public void changeHost(String code, String sessionId, String target) {
        Room room = findMyRoom(code, sessionId);
        if (room == null) {
            return;
        }

        synchronized (room) {
            if (room.changeHost(sessionNicknames.get(sessionId), target)) {
                sendPlayers(room);
                notice(room, target + "님이 새 방장이 되었어요.");
            }
        }
    }

    public void progress(String code, String sessionId, int progress) {
        Room room = findMyRoom(code, sessionId);
        if (room == null) {
            return;
        }

        GameMessage message = new GameMessage();
        message.setType("PROGRESS");
        message.setNickname(sessionNicknames.get(sessionId));
        message.setProgress(progress);
        send(room, message);
    }

    public void finish(String code, String sessionId, int cpm, int accuracy) {
        Room room = findMyRoom(code, sessionId);
        if (room == null) {
            return;
        }

        synchronized (room) {
            PlayerResult result = room.finish(sessionNicknames.get(sessionId), cpm, accuracy);
            if (result == null) {
                return;
            }

            GameMessage message = new GameMessage();
            message.setType("FINISH");
            message.setNickname(result.getNickname());
            message.setRank(result.getRank());
            message.setElapsedMs(result.getElapsedMs());
            message.setCpm(result.getCpm());
            message.setAccuracy(result.getAccuracy());
            send(room, message);

            if (room.isAllDone()) {
                endGame(room);
            }
        }
    }

    public void leave(String sessionId) {
        String code = sessionRooms.remove(sessionId);
        String nickname = sessionNicknames.remove(sessionId);
        if (code == null || nickname == null) {
            return;
        }
        Room room = roomService.findRoom(code);
        if (room == null) {
            return;
        }

        synchronized (room) {
            String oldHost = room.getHost();
            room.leave(nickname);

            if (!room.hasConnectedPlayer()) {
                roomService.removeRoom(code);
                return;
            }
            if (room.isEnded()) {
                return;
            }

            sendPlayers(room);
            if (room.isStarted()) {
                notice(room, nickname + "님의 연결이 끊겼어요.");
            } else {
                notice(room, nickname + "님이 나갔어요.");
                if (!room.isMatched() && nickname.equals(oldHost)) {
                    notice(room, room.getHost() + "님이 새 방장이 되었어요.");
                }
            }

            if (room.isAllDone()) {
                endGame(room);
            }
        }
    }

    public void checkRooms() {
        for (Room room : roomService.getRooms()) {
            synchronized (room) {
                if (room.isTimeOver()) {
                    notice(room, "제한 시간이 끝났어요.");
                    endGame(room);
                } else if (room.isMatched() && !room.isStarted()) {
                    checkMatchedRoom(room);
                } else if (!room.isStarted() && room.getPlayers().isEmpty()
                        && room.getWaitingMs() > EMPTY_ROOM_MS) {
                    roomService.removeRoom(room.getCode());
                }
            }
        }
    }

    private void checkMatchedRoom(Room room) {
        if (room.getWaitingMs() > MATCH_START_WAIT_MS && room.getPlayers().size() >= Room.MIN_PLAYERS) {
            notice(room, "오지 않은 참가자를 빼고 시작할게요.");
            startGame(room);
        } else if (room.getWaitingMs() > MATCH_CANCEL_MS) {
            GameMessage message = new GameMessage();
            message.setType("CANCELED");
            send(room, message);
            roomService.removeRoom(room.getCode());
        }
    }

    private Room findMyRoom(String code, String sessionId) {
        if (sessionId == null || code == null || !code.equals(sessionRooms.get(sessionId))) {
            return null;
        }
        return roomService.findRoom(code);
    }

    private void startGame(Room room) {
        if (room.start()) {
            GameMessage message = new GameMessage();
            message.setType("COUNTDOWN");
            send(room, message);
        }
    }

    private void endGame(Room room) {
        List<PlayerResult> results = room.end();
        if (results == null) {
            return;
        }
        if (room.isRanked()) {
            rankingService.applyRankedResults(results);
        }

        GameMessage message = new GameMessage();
        message.setType("END");
        message.setMode(room.getMode());
        message.setResults(results);
        send(room, message);
    }

    private void sendPlayers(Room room) {
        GameMessage message = new GameMessage();
        message.setType("PLAYERS");
        message.setPlayers(room.getPlayers());
        message.setLeft(room.getLeftPlayers());
        message.setHost(room.getHost());
        send(room, message);
    }

    private void notice(Room room, String text) {
        GameMessage message = new GameMessage();
        message.setType("NOTICE");
        message.setText(text);
        send(room, message);
    }

    private void send(Room room, GameMessage message) {
        messagingTemplate.convertAndSend("/topic/rooms/" + room.getCode(), message);
    }
}

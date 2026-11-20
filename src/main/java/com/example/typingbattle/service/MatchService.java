package com.example.typingbattle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.typingbattle.model.GameMessage;
import com.example.typingbattle.model.MatchTicket;
import com.example.typingbattle.model.Room;

@Service
public class MatchService {

    public static final int QUICK_MATCH_SIZE = 4;
    public static final long MAX_WAIT_MS = 5000;

    private final List<MatchTicket> normalQueue = new ArrayList<>();
    private final List<MatchTicket> rankedQueue = new ArrayList<>();

    private final RoomService roomService;
    private final SimpMessagingTemplate messagingTemplate;

    public MatchService(RoomService roomService, SimpMessagingTemplate messagingTemplate) {
        this.roomService = roomService;
        this.messagingTemplate = messagingTemplate;
    }

    public synchronized void join(String nickname, String ticket, String sessionId, String mode) {
        if (ticket == null || !ticket.matches("[a-zA-Z0-9]{8,40}")) {
            return;
        }
        if (!isValidNickname(nickname) || !isValidMode(mode)) {
            sendToTicket(ticket, "INVALID");
            return;
        }
        if (isWaiting(nickname)) {
            sendToTicket(ticket, "DUPLICATE");
            return;
        }

        getQueue(mode).add(new MatchTicket(nickname, ticket, sessionId, mode));
        sendWaiting(mode);
    }

    public synchronized void cancel(String sessionId) {
        if (removeBySession(normalQueue, sessionId)) {
            sendWaiting("NORMAL");
        }
        if (removeBySession(rankedQueue, sessionId)) {
            sendWaiting("RANKED");
        }
    }

    public synchronized void makeMatches(String mode) {
        List<MatchTicket> queue = getQueue(mode);
        boolean changed = false;

        while (queue.size() >= Room.MIN_PLAYERS) {
            boolean enough = queue.size() >= QUICK_MATCH_SIZE;
            boolean waitedLong = System.currentTimeMillis() - queue.get(0).getJoinedAt() >= MAX_WAIT_MS;
            if (!enough && !waitedLong) {
                break;
            }

            int size = Math.min(queue.size(), Room.MAX_PLAYERS);
            List<MatchTicket> group = new ArrayList<>(queue.subList(0, size));
            queue.subList(0, size).clear();
            createMatchRoom(group, mode);
            changed = true;
        }

        if (changed) {
            sendWaiting(mode);
        }
    }

    private void createMatchRoom(List<MatchTicket> group, String mode) {
        Room room = roomService.createRoom("RANDOM", mode, true);
        List<String> nicknames = new ArrayList<>();
        for (MatchTicket ticket : group) {
            nicknames.add(ticket.getNickname());
        }
        room.reserve(nicknames);

        for (MatchTicket ticket : group) {
            GameMessage message = new GameMessage();
            message.setType("MATCHED");
            message.setNickname(ticket.getNickname());
            message.setRoomCode(room.getCode());
            messagingTemplate.convertAndSend("/topic/match/" + ticket.getTicket(), message);
        }
    }

    private void sendWaiting(String mode) {
        GameMessage message = new GameMessage();
        message.setType("WAITING");
        message.setMode(mode);
        message.setWaiting(getQueue(mode).size());
        messagingTemplate.convertAndSend("/topic/match/waiting/" + mode, message);
    }

    private void sendToTicket(String ticket, String type) {
        GameMessage message = new GameMessage();
        message.setType(type);
        messagingTemplate.convertAndSend("/topic/match/" + ticket, message);
    }

    private boolean removeBySession(List<MatchTicket> queue, String sessionId) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getSessionId().equals(sessionId)) {
                queue.remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean isWaiting(String nickname) {
        for (MatchTicket ticket : normalQueue) {
            if (ticket.getNickname().equals(nickname)) {
                return true;
            }
        }
        for (MatchTicket ticket : rankedQueue) {
            if (ticket.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    private List<MatchTicket> getQueue(String mode) {
        if ("RANKED".equals(mode)) {
            return rankedQueue;
        }
        return normalQueue;
    }

    public static boolean isValidMode(String mode) {
        return "NORMAL".equals(mode) || "RANKED".equals(mode);
    }

    public static boolean isValidNickname(String nickname) {
        return nickname != null && !nickname.isBlank() && nickname.length() <= 10;
    }
}

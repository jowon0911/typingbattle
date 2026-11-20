package com.example.typingbattle.model;

import java.util.ArrayList;
import java.util.List;

import com.example.typingbattle.entity.Snippet;

public class Room {

    public static final int MAX_PLAYERS = 8;
    public static final int MIN_PLAYERS = 2;
    public static final long COUNTDOWN_MS = 3000;
    public static final long TIME_LIMIT_MS = 180000;
    public static final long MIN_MS_PER_CHAR = 30;

    private final String code;
    private final Snippet snippet;
    private final String mode;
    private final boolean matched;
    private final long createdAt = System.currentTimeMillis();
    private final List<String> players = new ArrayList<>();
    private final List<String> reserved = new ArrayList<>();
    private final List<String> leftPlayers = new ArrayList<>();
    private final List<PlayerResult> results = new ArrayList<>();
    private boolean started = false;
    private boolean ended = false;
    private long startTime = 0;

    public Room(String code, Snippet snippet, String mode, boolean matched) {
        this.code = code;
        this.snippet = snippet;
        this.mode = mode;
        this.matched = matched;
    }

    public synchronized void reserve(List<String> nicknames) {
        reserved.addAll(nicknames);
    }

    public synchronized boolean addPlayer(String nickname) {
        if (players.contains(nickname)) {
            return !leftPlayers.contains(nickname);
        }
        if (started || players.size() >= MAX_PLAYERS) {
            return false;
        }
        if (matched && !reserved.contains(nickname)) {
            return false;
        }
        players.add(nickname);
        return true;
    }

    public synchronized void leave(String nickname) {
        if (!players.contains(nickname)) {
            return;
        }
        if (started) {
            if (!leftPlayers.contains(nickname)) {
                leftPlayers.add(nickname);
            }
        } else {
            players.remove(nickname);
        }
    }

    public synchronized boolean changeHost(String nickname, String target) {
        if (started || matched || !isHost(nickname)) {
            return false;
        }
        if (target == null || target.equals(nickname) || !players.contains(target)) {
            return false;
        }
        players.remove(target);
        players.add(0, target);
        return true;
    }

    public synchronized boolean canStart(String nickname) {
        return !started && !matched && isHost(nickname) && players.size() >= MIN_PLAYERS;
    }

    public synchronized boolean start() {
        if (started || players.size() < MIN_PLAYERS) {
            return false;
        }
        started = true;
        startTime = System.currentTimeMillis() + COUNTDOWN_MS;
        return true;
    }

    public synchronized PlayerResult finish(String nickname, int cpm, int accuracy) {
        if (!started || ended || !isActivePlayer(nickname) || hasFinished(nickname)) {
            return null;
        }
        long elapsedMs = getElapsedMs();
        if (elapsedMs < snippet.getContent().length() * MIN_MS_PER_CHAR) {
            return null;
        }
        PlayerResult result = new PlayerResult();
        result.setRank(results.size() + 1);
        result.setNickname(nickname);
        result.setElapsedMs(elapsedMs);
        result.setCpm(cpm);
        result.setAccuracy(accuracy);
        result.setFinished(true);
        results.add(result);
        return result;
    }

    public synchronized boolean isAllDone() {
        if (!started || ended) {
            return false;
        }
        for (String player : players) {
            if (!leftPlayers.contains(player) && !hasFinished(player)) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean isTimeOver() {
        return started && !ended && System.currentTimeMillis() - startTime > TIME_LIMIT_MS;
    }

    public synchronized List<PlayerResult> end() {
        if (!started || ended) {
            return null;
        }
        ended = true;
        List<PlayerResult> finalResults = new ArrayList<>(results);
        for (String player : players) {
            if (!hasFinished(player)) {
                PlayerResult result = new PlayerResult();
                result.setRank(players.size());
                result.setNickname(player);
                result.setFinished(false);
                result.setLeft(leftPlayers.contains(player));
                finalResults.add(result);
            }
        }
        return finalResults;
    }

    private boolean hasFinished(String nickname) {
        for (PlayerResult result : results) {
            if (result.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isActivePlayer(String nickname) {
        return players.contains(nickname) && !leftPlayers.contains(nickname);
    }

    public synchronized boolean hasConnectedPlayer() {
        return players.size() > leftPlayers.size();
    }

    public synchronized boolean isAllReservedJoined() {
        return !reserved.isEmpty() && players.containsAll(reserved);
    }

    public synchronized boolean isReserved(String nickname) {
        return reserved.contains(nickname);
    }

    public synchronized long getElapsedMs() {
        return System.currentTimeMillis() - startTime;
    }

    public synchronized long getWaitingMs() {
        return System.currentTimeMillis() - createdAt;
    }

    public synchronized boolean isHost(String nickname) {
        return !players.isEmpty() && players.get(0).equals(nickname);
    }

    public synchronized String getHost() {
        if (players.isEmpty()) {
            return null;
        }
        return players.get(0);
    }

    public synchronized boolean isStarted() {
        return started;
    }

    public synchronized boolean isEnded() {
        return ended;
    }

    public synchronized boolean isFull() {
        return players.size() >= MAX_PLAYERS;
    }

    public synchronized boolean hasPlayer(String nickname) {
        return players.contains(nickname);
    }

    public synchronized List<String> getPlayers() {
        return new ArrayList<>(players);
    }

    public synchronized List<String> getLeftPlayers() {
        return new ArrayList<>(leftPlayers);
    }

    public String getCode() {
        return code;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public String getMode() {
        return mode;
    }

    public boolean isMatched() {
        return matched;
    }

    public boolean isRanked() {
        return "RANKED".equals(mode);
    }

    public String getModeLabel() {
        if (isRanked()) {
            return "경쟁전";
        }
        if (matched) {
            return "일반전 · 랜덤 매칭";
        }
        return "일반전 · 친구 방";
    }
}

package com.example.typingbattle.model;

import java.util.ArrayList;
import java.util.List;

import com.example.typingbattle.entity.Snippet;

public class Room {

    public static final int MAX_PLAYERS = 8;
    public static final int MIN_PLAYERS = 2;

    private final String code;
    private final Snippet snippet;
    private final List<String> players = new ArrayList<>();
    private boolean started = false;
    private long startTime = 0;
    private final List<String> finishedPlayers = new ArrayList<>();

    public Room(String code, Snippet snippet) {
        this.code = code;
        this.snippet = snippet;
    }

    public synchronized boolean addPlayer(String nickname) {
        if (players.contains(nickname)) {
            return true;
        }
        if (started || players.size() >= MAX_PLAYERS) {
            return false;
        }
        players.add(nickname);
        return true;
    }

    public synchronized boolean canStart(String nickname) {
        return !started && isHost(nickname) && players.size() >= MIN_PLAYERS;
    }

    public synchronized boolean start() {
        if (started) {
            return false;
        }
        started = true;
        startTime = System.currentTimeMillis() + 3000;
        return true;
    }

    public synchronized int finish(String nickname) {
        if (!finishedPlayers.contains(nickname)) {
            finishedPlayers.add(nickname);
        }
        return finishedPlayers.indexOf(nickname) + 1;
    }

    public synchronized long getElapsedMs() {
        return System.currentTimeMillis() - startTime;
    }

    public synchronized boolean isHost(String nickname) {
        return !players.isEmpty() && players.get(0).equals(nickname);
    }

    public synchronized boolean isStarted() {
        return started;
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

    public String getCode() {
        return code;
    }

    public Snippet getSnippet() {
        return snippet;
    }
}
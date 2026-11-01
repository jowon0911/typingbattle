package com.example.typingbattle.model;

import java.util.List;

public class GameMessage {

    private String type;
    private String nickname;
    private List<String> players;
    private int progress;
    private int rank;
    private long elapsedMs;
    private int cpm;
    private int accuracy;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public void setRank(int rank) {
    }

    public void setElapsedMs(long elapsedMs) {
    }
}
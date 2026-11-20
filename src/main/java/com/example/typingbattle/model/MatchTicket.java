package com.example.typingbattle.model;

public class MatchTicket {

    private final String nickname;
    private final String ticket;
    private final String sessionId;
    private final String mode;
    private final long joinedAt = System.currentTimeMillis();

    public MatchTicket(String nickname, String ticket, String sessionId, String mode) {
        this.nickname = nickname;
        this.ticket = ticket;
        this.sessionId = sessionId;
        this.mode = mode;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTicket() {
        return ticket;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getMode() {
        return mode;
    }

    public long getJoinedAt() {
        return joinedAt;
    }
}

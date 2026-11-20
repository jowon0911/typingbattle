package com.example.typingbattle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerStat {

    public static final int START_SCORE = 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nickname;

    private int score = START_SCORE;

    private int games;

    private int wins;

    private int bestCpm;

    protected PlayerStat() {
    }

    public PlayerStat(String nickname) {
        this.nickname = nickname;
    }

    public void addResult(int scoreChange, boolean win, int cpm) {
        score = Math.max(0, score + scoreChange);
        games++;
        if (win) {
            wins++;
        }
        if (cpm > bestCpm) {
            bestCpm = cpm;
        }
    }

    public String getTier() {
        if (score >= 1300) {
            return "다이아";
        }
        if (score >= 1150) {
            return "플래티넘";
        }
        if (score >= 1050) {
            return "골드";
        }
        if (score >= 950) {
            return "실버";
        }
        return "브론즈";
    }

    public String getTierCode() {
        if (score >= 1300) {
            return "diamond";
        }
        if (score >= 1150) {
            return "platinum";
        }
        if (score >= 1050) {
            return "gold";
        }
        if (score >= 950) {
            return "silver";
        }
        return "bronze";
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    public int getGames() {
        return games;
    }

    public int getWins() {
        return wins;
    }

    public int getBestCpm() {
        return bestCpm;
    }
}

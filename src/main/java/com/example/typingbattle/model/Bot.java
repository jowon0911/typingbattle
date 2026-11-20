package com.example.typingbattle.model;

public class Bot {

    private final String name;
    private final String level;
    private final int cpm;
    private final int accuracy;
    private int lastProgress = 0;

    public Bot(String name, String level, int cpm, int accuracy) {
        this.name = name;
        this.level = level;
        this.cpm = cpm;
        this.accuracy = accuracy;
    }

    public int getProgress(long elapsedMs, int length) {
        if (elapsedMs <= 0 || length == 0) {
            return 0;
        }
        long typed = elapsedMs * cpm / 60000;
        if (typed >= length) {
            return 100;
        }
        return (int) (typed * 100 / length);
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getCpm() {
        return cpm;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getLastProgress() {
        return lastProgress;
    }

    public void setLastProgress(int lastProgress) {
        this.lastProgress = lastProgress;
    }
}

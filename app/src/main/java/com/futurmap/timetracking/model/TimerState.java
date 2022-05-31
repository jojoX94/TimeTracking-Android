package com.futurmap.timetracking.model;

public class TimerState {
    private boolean isPaused = true;
    private long currentTime = 0;
    private String timeSinceStarted;

    

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public String getTimeSinceStarted() {
        return timeSinceStarted;
    }

    public void setTimeSinceStarted(String timeSinceStarted) {
        this.timeSinceStarted = timeSinceStarted;
    }
}

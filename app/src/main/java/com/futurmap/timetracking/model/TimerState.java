package com.futurmap.timetracking.model;

public class TimerState {
    private boolean isPaused = true;
    private long currentTime = 0;
    private String project;

    public TimerState() {
    }

    public TimerState(String project) {
        this.project = project;
    }

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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}


package com.scheduler;

public class Meeting {
    private String title;
    private String startTime;
    private String endTime;

    public Meeting() {}

    public Meeting(String title, String startTime, String endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean overlaps(Meeting other) {
        return this.startTime.compareTo(other.endTime) < 0 &&
               this.endTime.compareTo(other.startTime) > 0;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}

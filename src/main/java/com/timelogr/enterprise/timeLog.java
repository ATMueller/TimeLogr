package com.timelogr.enterprise;

public class timeLog {
    private long id;
    private long date; //IN UNIXTIMESTAMP
    private long duration; //IN SECONDS

    public timeLog() {
        super();
    }

    public timeLog(long id, long date, long duration) {
        this.id = id;
        this.date = date;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}

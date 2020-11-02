package com.timelogr.enterprise.dto;

import lombok.Data;

public @Data
class TimeLog {
    private long id;
    private long date; // IN UNIX TIMESTAMP
    private long duration; // IN SECONDS

    public TimeLog() {
        super();
    }

    public TimeLog(long id, long date, long duration) {
        this.id = id;
        this.date = date;
        this.duration = duration;
    }
}

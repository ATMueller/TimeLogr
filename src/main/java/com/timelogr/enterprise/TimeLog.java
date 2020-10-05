package com.timelogr.enterprise;

import lombok.Data;

public @Data
class TimeLog {

    private long timeLogID;
    private long timeLogDate; // IN UNIX TIME STAMP
    private long timeLogDuration; // IN SECONDS

    public TimeLog() {
        super();
    }

    public TimeLog(long id, long date, long duration) {
        this.timeLogID = id;
        this.timeLogDate = date;
        this.timeLogDuration = duration;
    }
}

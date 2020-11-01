package com.timelogr.enterprise.dto;

import lombok.Data;

public @Data class TimeLog {
    private String client;
    private String project;
    private int id;
    private long date; //IN UNIXTIMESTAMP
    private long duration; //IN SECONDS
    private long emp_id;
}

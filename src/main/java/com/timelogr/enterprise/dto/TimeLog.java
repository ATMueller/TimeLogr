package com.timelogr.enterprise.dto;

import lombok.Data;

import javax.persistence.*;

@Entity @Table (name = "TIMELOG")
public @Data class TimeLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String client;
    private String project;
    private long date;
    private long duration;
    private long emp_id;
}

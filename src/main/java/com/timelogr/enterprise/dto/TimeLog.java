package com.timelogr.enterprise.dto;

import lombok.Data;

import javax.persistence.*;

@Entity @Table (name = "TIMELOG")
public @Data class TimeLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int clientID;
    private int projectID;
    private int employeeID;
    private long date;
    private long duration;
}

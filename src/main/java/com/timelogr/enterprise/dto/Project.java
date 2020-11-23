package com.timelogr.enterprise.dto;

import lombok.Data;

import javax.persistence.*;

@Entity @Table (name = "PROJECT")
public @Data class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private double wage;
    private String client;
    private int clientId;
    private double budget;
    private double hours;
}

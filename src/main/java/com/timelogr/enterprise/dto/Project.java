package com.timelogr.enterprise.dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity @Table (name = "PROJECT")
public @Data class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Please enter a Name")
    private String name;

    @Min(value = 1, message = "Please set a wage")
    private double wage;


    private int clientId;

    @Min(value = 1, message = "Please set a budget")
    private double budget;


    private double hours;

    @NotEmpty(message = "Please enter a Description")
    private String description;
}

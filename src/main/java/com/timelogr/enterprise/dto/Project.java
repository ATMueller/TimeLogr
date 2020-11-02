package com.timelogr.enterprise.dto;

import lombok.Data;

public @Data
class Project {
    private long id;
    private String name;
    private double wage;

    public Project() {
        super();
    }

    public Project(long id, String name, double wage) {
        super();
        this.id = id;
        this.name = name;
        this.wage = wage;
    }
}

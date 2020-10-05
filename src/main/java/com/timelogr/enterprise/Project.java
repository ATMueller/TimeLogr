package com.timelogr.enterprise;

import lombok.Data;

public @Data
class Project {

    private long projectID;
    private String projectName;
    private double projectWage;

    public Project() {
        super();
    }

    public Project(long id, String name, double wage) {
        super();
        this.projectID = id;
        this.projectName = name;
        this.projectWage = wage;
    }
}

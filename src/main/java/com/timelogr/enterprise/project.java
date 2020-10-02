package com.timelogr.enterprise;

public class project {
    private long id;
    private String name;
    private double wage;

    public project() {
        super();
    }

    public project(long id, String name, double wage) {
        super();
        this.id = id;
        this.name = name;
        this.wage = wage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}

package com.timelogr.enterprise.dto;

import lombok.Data;

public @Data
class Employee {
    private long id;
    private String name;
    private String email;
    private String number;

    public Employee() {
        super();
    }

    public Employee(long id, String name, String email, String number) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }
}


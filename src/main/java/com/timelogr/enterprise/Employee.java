package com.timelogr.enterprise;

import lombok.Data;

public @Data
class Employee {

    private long employeeID;
    private String employeeName;
    private String employeeEmail;
    private String employeeNumber;

    public Employee() {
        super();
    }

    public Employee(long id, String name, String email, String number) {
        super();
        this.employeeID = id;
        this.employeeName = name;
        this.employeeEmail = email;
        this.employeeNumber = number;
    }
}


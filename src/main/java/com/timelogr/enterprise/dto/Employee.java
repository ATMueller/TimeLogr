package com.timelogr.enterprise.dto;

import lombok.Data;
import javax.persistence.*;

@Entity @Table (name = "EMPLOYEE")
public @Data
class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String number;
}


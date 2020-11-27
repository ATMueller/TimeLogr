package com.timelogr.enterprise.dto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import lombok.Data;
import org.junit.platform.commons.util.ToStringBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity @Table(name = "ACCOUNT")
public @Data class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String name;
    private String email;
    private String number;
    private String password;
    private String type; //DEV OR CLIENT


}

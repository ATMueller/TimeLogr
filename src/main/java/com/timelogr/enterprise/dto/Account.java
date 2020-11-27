package com.timelogr.enterprise.dto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import lombok.Data;
import javax.persistence.*;


@Getter
@Setter
@Entity @Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String number;
    private String type; //DEV OR CLIENT
}

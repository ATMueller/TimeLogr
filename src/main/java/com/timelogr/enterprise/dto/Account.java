package com.timelogr.enterprise.dto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Account {
    private long id;
    private String name;
    private String email;
    private String number;
    private String type; //DEV OR CLIENT
}

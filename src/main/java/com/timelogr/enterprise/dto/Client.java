package com.timelogr.enterprise.dto;


import lombok.Data;

public @Data
class Client {
    private long id;
    private String name;
    private String email;
    private String number;
}

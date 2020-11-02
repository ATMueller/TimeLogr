package com.timelogr.enterprise.dto;

import lombok.Data;

public @Data
class Client {
    private long id;
    private String name;
    private String email;
    private String number;

    public Client() {
        super();
    }

    public Client(long id, String name, String email, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }
}

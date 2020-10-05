package com.timelogr.enterprise;

import lombok.Data;

public @Data
class Client {

    private long clientID;
    private String clientName;
    private String clientEmail;
    private String clientNumber;

    public Client() {
        super();
    }

    public Client(long id, String name, String email, String number) {
        this.clientID = id;
        this.clientName = name;
        this.clientEmail = email;
        this.clientNumber = number;
    }
}

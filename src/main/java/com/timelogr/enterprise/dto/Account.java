package com.timelogr.enterprise.dto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import lombok.Data;
import org.junit.platform.commons.util.ToStringBuilder;
import javax.validation.constraints.*;


@Entity @Table(name = "ACCOUNT")
public @Data class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotEmpty(message = "Please enter a Name")
    private String name;

    @Email @NotEmpty(message = "Please enter a Email")
    private String email;

    @NotEmpty(message = "Please enter a number (Doesnt have to be a true phone number)")
    private String number;

    @NotEmpty(message = "Please enter a Password")
    private String password;

    @NotEmpty(message = "Please select the Account type")
    private String type; //DEV OR CLIENT


}

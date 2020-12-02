package com.timelogr.enterprise.dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@Entity
@Table(name = "PROJECT")
public @Data class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Please enter a Name")
    private String name;

    @DecimalMin(value ="0.10", message = "Please enter a Wage")
    private BigDecimal wage;

    private int clientId;

    @DecimalMin(value ="0.10", message = "Please enter a Budget")
    private BigDecimal budget;

    @NotEmpty(message = "Please enter a Description")
    private String description;

}

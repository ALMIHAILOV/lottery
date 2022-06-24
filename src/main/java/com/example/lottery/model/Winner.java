package com.example.lottery.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long Id;

    @NotNull
    private String name;

    @NotNull
    private int age;

    @NotNull
    private String city;

    @NotNull
    private int amount;
}

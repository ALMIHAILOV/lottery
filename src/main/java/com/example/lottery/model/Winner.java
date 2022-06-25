package com.example.lottery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

package com.example.Spring_Boot_REST_API_1.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeDto {
    private String firstname;
    private String lastname;
    private boolean active;
    private LocalDate created;
}

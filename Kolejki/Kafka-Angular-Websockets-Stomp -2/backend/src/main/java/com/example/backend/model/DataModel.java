package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "carsales")

@RequiredArgsConstructor
@Getter
@Setter
public class DataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String carYear;
    private LocalDate saleTimestamp;
    private String dealerName;
    private String state;
    private Double price;
}

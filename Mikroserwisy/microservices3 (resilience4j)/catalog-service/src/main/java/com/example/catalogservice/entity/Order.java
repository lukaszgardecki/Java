package com.example.catalogservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDERS_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String color;
    private BigDecimal price;

    public Order(String name, String category, String color, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.price = price;
    }
}

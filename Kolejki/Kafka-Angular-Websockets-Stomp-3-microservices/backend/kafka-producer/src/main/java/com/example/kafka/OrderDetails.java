package com.example.kafka;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderDetails {
    private Long id;
    private String product;
    private String status;
    private Double price;
}

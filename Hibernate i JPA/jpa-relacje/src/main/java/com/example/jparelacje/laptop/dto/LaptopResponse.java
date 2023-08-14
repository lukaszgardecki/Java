package com.example.jparelacje.laptop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LaptopResponse {
    private Long id;
    private String modelNumber;
    private String brand;
}

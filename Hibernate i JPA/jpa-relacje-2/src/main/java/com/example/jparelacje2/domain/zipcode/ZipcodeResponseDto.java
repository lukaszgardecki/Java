package com.example.jparelacje2.domain.zipcode;

import com.example.jparelacje2.domain.city.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipcodeResponseDto {
    private Long id;
    private String name;
    private City city;
}


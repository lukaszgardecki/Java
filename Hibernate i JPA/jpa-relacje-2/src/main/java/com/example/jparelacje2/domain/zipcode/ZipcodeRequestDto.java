package com.example.jparelacje2.domain.zipcode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipcodeRequestDto {
    private String name;
    private Long cityId;
}

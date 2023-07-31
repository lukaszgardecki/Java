package com.example.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Long id;
    private String lane1;
    private String lane2;
    private long zip;
    private String state;
}

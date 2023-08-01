package com.example.employeeservice.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Long id;
    private String lane1;
    private String lane2;
    private long zip;
    private String state;
    private Long employee_id;
}

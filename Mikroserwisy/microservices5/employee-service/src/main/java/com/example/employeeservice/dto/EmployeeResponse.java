package com.example.employeeservice.dto;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String bloodGroup;
    private AddressResponse address;
}

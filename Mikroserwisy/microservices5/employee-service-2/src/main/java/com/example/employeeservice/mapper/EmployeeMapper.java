package com.example.employeeservice.mapper;

import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static EmployeeResponse mapToDto(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .bloodGroup(employee.getBloodGroup())
                .build();
    }
}

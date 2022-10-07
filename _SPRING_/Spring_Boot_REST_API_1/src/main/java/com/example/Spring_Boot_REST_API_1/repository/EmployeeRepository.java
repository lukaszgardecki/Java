package com.example.Spring_Boot_REST_API_1.repository;

import com.example.Spring_Boot_REST_API_1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

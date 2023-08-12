package com.example.Springboot.repository;


import com.example.Springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentName(String departmentName);

    Department findByDepartmentNameIgnoreCase(String departmentName);
}

package com.example.departmentservice.client;

import com.example.departmentservice.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange(url = "http://employee-service")
public interface EmployeeClient {

    @GetExchange("/employee/department/{departmentId}")
    List<Employee> findEmployeesByDepartmentId(@PathVariable Long departmentId);

}

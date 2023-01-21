package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    String home(Model model) {
        List<Employee> employees = repository.findAll();
        BigDecimal avgSalary = repository.getAvgSalary();
        model.addAttribute("employees", employees);
        model.addAttribute("avgSalary", avgSalary);
        return "index";
    }
}

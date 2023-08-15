package com.example.spring_boot_tutorial;

import com.example.spring_boot_tutorial.dto.DepartmentRequest;
import com.example.spring_boot_tutorial.dto.DepartmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {
    private final DepartmentService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentResponse saveDepartment(@Valid @RequestBody DepartmentRequest department) {
        log.info("Inside saveDepartment method");
        return service.saveDepartment(department);
    }

    @GetMapping
    public List<DepartmentResponse> fetchDepartmentList() {
        log.info("Inside fetchDepartmentList method");
        return service.fetchDepartmentList();
    }

    @GetMapping("/{departmentId}")
    public DepartmentResponse fetchDepartmentById(@PathVariable Long departmentId) {
        log.info("Inside fetchDepartmentById method");
        return service.fetchDepartmentById(departmentId);
    }

    @GetMapping("/name/{departmentName}")
    public DepartmentResponse fetchDepartmentByName(@PathVariable String departmentName) {
        log.info("Inside fetchDepartmentByName method");
        return service.fetchDepartmentByName(departmentName);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartmentById(@PathVariable Long departmentId) {
        log.info("Inside deleteDepartmentById method");
        service.deleteDepartmentById(departmentId);
    }

    @PutMapping("/{departmentId}")
    public DepartmentResponse updateDepartmentById(@PathVariable Long departmentId, @RequestBody DepartmentRequest department) {
        log.info("Inside updateDepartmentById method");
        return service.updateDepartmentById(departmentId, department);
    }
}

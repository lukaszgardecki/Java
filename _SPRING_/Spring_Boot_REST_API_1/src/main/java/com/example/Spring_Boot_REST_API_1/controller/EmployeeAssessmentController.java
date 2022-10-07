package com.example.Spring_Boot_REST_API_1.controller;

import com.example.Spring_Boot_REST_API_1.model.EmployeeAssessment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAssessmentController {

    @PutMapping("/employees/{id}/assessments/{assessmentId}")
    public EmployeeAssessment updateAssessment(@PathVariable Long id, @PathVariable Long assessmentId) {
        return null;
    }
}

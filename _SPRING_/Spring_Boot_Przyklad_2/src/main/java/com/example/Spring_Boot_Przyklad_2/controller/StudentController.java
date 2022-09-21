package com.example.Spring_Boot_Przyklad_2.controller;

import com.example.Spring_Boot_Przyklad_2.model.Student;
import com.example.Spring_Boot_Przyklad_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).get();
    }
}

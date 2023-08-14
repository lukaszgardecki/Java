package com.example.web;

import com.example.jparelacje.student.StudentService;
import com.example.jparelacje.student.dto.StudentRequest;
import com.example.jparelacje.student.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public StudentResponse save(@RequestBody StudentRequest student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<StudentResponse> findAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentResponse findStudentById(@PathVariable Long studentId) {
        return studentService.findStudentById(studentId)
                .orElseThrow();
    }
}

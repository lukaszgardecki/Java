package com.example.springdatajpa.coursematerial;

import com.example.springdatajpa.course.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void shouldSaveCourseMaterial() {
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void shouldPrintAllCourses() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("Materiały: " + courseMaterials);
    }
}
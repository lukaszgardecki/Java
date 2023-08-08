package com.example.springdatajpa.teacher;

import com.example.springdatajpa.course.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void shouldSaveTeacher() {

        Course course1 = Course.builder()
                .title("Kurs jakiś")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .title("Kurs Java")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstname("Andrzej")
                .lastname("Leper")
//                .courses(List.of(course1, course2))
                .build();
        repository.save(teacher);
    }
}
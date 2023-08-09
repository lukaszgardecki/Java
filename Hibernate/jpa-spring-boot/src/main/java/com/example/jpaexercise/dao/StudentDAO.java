package com.example.jpaexercise.dao;

import com.example.jpaexercise.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Long> {
}

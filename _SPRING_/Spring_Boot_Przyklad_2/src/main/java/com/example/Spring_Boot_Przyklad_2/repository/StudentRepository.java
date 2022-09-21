package com.example.Spring_Boot_Przyklad_2.repository;

import com.example.Spring_Boot_Przyklad_2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.example.studentservice.service;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student teacher) {
        Student existingStudent = studentRepository.findById(id).orElseThrow();
        existingStudent.setName(teacher.getName());
        existingStudent.setAge(teacher.getAge());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}

package com.example.jparelacje.student;

import com.example.jparelacje.student.dto.StudentRequest;
import com.example.jparelacje.student.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student studentToSave = getStudentFromRequest(studentRequest);
        Student savedStudent = studentRepository.save(studentToSave);
        StudentResponse studentResponse = getStudentResponseFromStudent(savedStudent);
        return studentResponse;
    }

    public List<StudentResponse> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::getStudentResponseFromStudent)
                .toList();
    }

    public Optional<StudentResponse> findStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::getStudentResponseFromStudent);
    }

    private StudentResponse getStudentResponseFromStudent(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .about(student.getAbout())
                .laptop(student.getLaptop())
                .build();
    }

    private Student getStudentFromRequest(StudentRequest request) {
        return Student.builder()
                .name(request.getName())
                .about(request.getAbout())
                .laptop(request.getLaptop())
                .build();
    }


}

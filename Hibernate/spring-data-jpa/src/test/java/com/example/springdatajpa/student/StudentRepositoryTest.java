package com.example.springdatajpa.student;

import com.example.springdatajpa.guardian.Guardian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void shouldSaveStudent() {
        Student student = Student.builder()
                .emailId("asdf@gmail.com")
                .firstname("Tomek")
                .lastname("Atomek")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void shouldSaveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("ggg@asdf.com")
                .name("QWER")
                .mobile("234789")
                .build();
        Student student = Student.builder()
                .emailId("asdf@gmail.com")
                .firstname("Kasia")
                .lastname("Prasia")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void shouldPrintAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void shouldPrintStudentByFirstname() {
        List<Student> students = studentRepository.findByFirstname("Kasia");
        System.out.println("Studenci: " + students);
    }

    @Test
    public void shouldPrintStudentByFirstnameContaining() {
        List<Student> students = studentRepository.findByFirstnameContaining("si");
        System.out.println("Studenci: " + students);
    }

    @Test
    public void shouldPrintStudentByLastnameNotNull() {
        List<Student> students = studentRepository.findByLastnameNotNull();
        System.out.println("Studenci: " + students);
    }

    @Test
    public void shouldPrintStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("QWER");
        System.out.println("Studenci: " + students);
    }

    @Test
    public void shouldPrintStudentByFirstnameAndLastname() {
        Student student = studentRepository.findByFirstnameAndLastname("Kasia", "Prasia");
        System.out.println("Studenci: " + student);
    }

    @Test
    public void shouldPrintStudentByAddressEmailWithQueryMethod() {
        Student student = studentRepository.getStudentByEmailAddressWithQueryMethod("asdf@gmail.com");
        System.out.println("Studenci: " + student);
    }

    @Test
    public void shouldPrintStudentFirstnameByAddressEmailWithQueryMethod() {
        String student = studentRepository.getStudentFirstNameByEmailAddressWithQueryMethod("asdf@gmail.com");
        System.out.println("Studenci: " + student);
    }

    @Test
    public void shouldPrintStudentByAddressEmailWithNativeQueryMethod() {
        Student student = studentRepository.getStudentByEmailAddressWithNativeQueryMethod("asdf@gmail.com");
        System.out.println("Studenci: " + student);
    }

    @Test
    public void shouldPrintStudentFirstnameByAddressEmailWithNativeQueryMethod() {
        String student = studentRepository.getStudentFirstNameByEmailAddressWithNativeQueryMethod("asdf@gmail.com");
        System.out.println("Studenci: " + student);
    }

    @Test
    public void shouldUpdateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Krysia", "asdf@gmail.com");
    }
}
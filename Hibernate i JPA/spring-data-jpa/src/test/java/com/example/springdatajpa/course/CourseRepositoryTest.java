package com.example.springdatajpa.course;

import com.example.springdatajpa.student.Student;
import com.example.springdatajpa.teacher.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void shouldPrintCourses() {
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }

    @Test
    public void shouldSaveCourse() {
        Teacher teacher = Teacher.builder()
                .firstname("Kazik")
                .lastname("albonie")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

    @Test
    public void shouldFindAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = repository.findAll(firstPageWithThreeRecords)
                .getContent();

        long totalElements = repository.findAll(firstPageWithThreeRecords).getTotalElements();
        int totalPages = repository.findAll(firstPageWithThreeRecords).getTotalPages();


        System.out.println("Kursy: " + courses);
        System.out.println("Ilość elementów: " + totalElements);
        System.out.println("Ilość stron: " + totalPages);
    }

    @Test
    public void shouldFindAllSorting() {
        PageRequest sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        PageRequest sortByCreditDescending = PageRequest.of(0, 2, Sort.by("credit").descending());
        PageRequest sortByTitleDescAndCredit = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> coursesSortedByTitle = repository.findAll(sortByTitle).getContent();
        List<Course> coursesSortedByCreditDescending = repository.findAll(sortByCreditDescending).getContent();
        List<Course> coursesSortedByTitleDescAndCredit = repository.findAll(sortByTitleDescAndCredit).getContent();

        System.out.println("Kursy sortowane po tytule:");
        coursesSortedByTitle.forEach(course -> System.out.println(" - " + course));

        System.out.println("Kursy sortowane po kredytach malejąco:");
        coursesSortedByCreditDescending.forEach(course -> System.out.println(" - " + course));

        System.out.println("Kursy sortowane po tytule malejąco i po kredytach:");
        coursesSortedByTitleDescAndCredit.forEach(course -> System.out.println(" - " + course));
    }

    @Test
    public void shouldPrintFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = repository.findByTitleContaining("D", firstPageTenRecords)
                .getContent();

        System.out.println("Kursy: " + courses);
    }

    @Test
    public void shouldSaveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstname("Jakiś nauczeyciel")
                .lastname("Morgan")
                .build();

        Student student = Student.builder()
                .firstname("Czesiek")
                .lastname("Mozil")
                .emailId("tratra@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudent(student);

        repository.save(course);
    }
}
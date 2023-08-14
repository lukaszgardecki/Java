package com.example.springdatajpa.course;

import com.example.springdatajpa.coursematerial.CourseMaterial;
import com.example.springdatajpa.student.Student;
import com.example.springdatajpa.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(                                         // relacja ManyToMany wymaga tabeli pośredniczącej
            name = "student_course_map",                // tabela ta będzie się nazywać 'student_course_map'
            joinColumns = @JoinColumn(                  // kolumna 1 (dotyczy tej klasy):
                    name = "course_id",                 //     - nazwa: 'course_id'
                    referencedColumnName = "id"         //     - zawartość: pole 'id' z tabeli 'course' (z klasy Course)
            ),
            inverseJoinColumns = @JoinColumn(           // kolumna 2:
                    name = "student_id",                //     - nazwa: 'student_id'
                    referencedColumnName = "id"         //     - zawartość: pole 'id' z tabeli 'tbl_student' (z klasy Student)
            )
    )
    private List<Student> students;


    public void addStudent(Student student) {
        if (students == null) students = new ArrayList<>();
        students.add(student);
    }
}

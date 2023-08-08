package com.example.springdatajpa.teacher;

import com.example.springdatajpa.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",            // do tabeli z kursami (course) dodaj kolumnę 'teacher_id'
//            referencedColumnName = "id"     // która będzie wskazywać pole 'id' z tabeli 'teacher'
//    )
//    private List<Course> courses;
}

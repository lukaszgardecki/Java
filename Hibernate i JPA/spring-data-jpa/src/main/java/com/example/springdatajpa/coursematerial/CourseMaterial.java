package com.example.springdatajpa.coursematerial;

import com.example.springdatajpa.course.Course;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long id;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false                // oznacza, że materiał może być zapisany TYLKO jeśli posiada przypisany kurs, materiał sam w sobie nie może być przypisany, tylko z kursem
    )
    @JoinColumn(
            name = "course_id",             // chcemy by dodana kolumna nazywała się 'course_id'
            referencedColumnName = "id"     // dane w tej kolumnie mają być brane z Course z pola 'id'
    )                                       // czyli: utwórz kolumnę 'course_id', która wskazuje na kolumnę 'id' w Course
    private Course course;
}

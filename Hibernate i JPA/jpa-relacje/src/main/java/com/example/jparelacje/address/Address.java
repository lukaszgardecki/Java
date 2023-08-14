package com.example.jparelacje.address;

import com.example.jparelacje.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String country;

    @ManyToOne
    // @JoinColumn = jak będziesz pobierał dane z tabeli 'address'
    // to poprzez id w kolumnie 'student_id' dostań się do danych
    // studenta i zamień je na obiekt Student
    // Ta adnotacja jest przydatna przy POBIERANIU danych z bazy, nie przy zapisywaniu
    @JoinColumn(name = "student_id")
    private Student student;
}

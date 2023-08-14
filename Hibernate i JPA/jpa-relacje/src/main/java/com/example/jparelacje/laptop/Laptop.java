package com.example.jparelacje.laptop;

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
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelNumber;
    private String brand;

    //czysta adnotacja @OneToOne dodaje dodatkową kolumnę 'student_id' w tabeli
    @OneToOne
    // @JoinColumn = jak będziesz pobierał dane z tabeli 'laptop'
    // to poprzez id w kolumnie 'student_id' dostań się do danych
    // studenta i zamień je na obiekt Student
    // Ta adnotacja jest przydatna przy POBIERANIU danych z bazy, nie przy zapisywaniu
    @JoinColumn(name = "student_id")
    private Student student;
}

package com.example.jparelacje.student;

import com.example.jparelacje.address.Address;
import com.example.jparelacje.laptop.Laptop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String about;

    // Samo tylko dodanie czystej adnotacji @OneToOne powoduje dodanie dodatkowej kolumny laptop_id do tabeli student
    // w naszej tabeli pojawi się dodatkowa kolumna laptop_id
    // cascade = "jak zapisujesz w bazie studenta to zapisz też laptopa"
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    // cascade = "jak zapisuejsz w bazie studenta to zapisz też jego adresy"
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();
}

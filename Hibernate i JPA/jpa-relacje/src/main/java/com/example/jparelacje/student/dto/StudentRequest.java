package com.example.jparelacje.student.dto;

import com.example.jparelacje.laptop.Laptop;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentRequest {
    private String name;
    private String about;
    private Laptop laptop;
}

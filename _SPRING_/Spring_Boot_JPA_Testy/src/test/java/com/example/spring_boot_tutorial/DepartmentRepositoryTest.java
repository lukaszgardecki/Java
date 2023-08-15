package com.example.spring_boot_tutorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("IT")
                .address("Katowice")
                .code("C123")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void shouldReturnDepartmentWhenFindByIdAndIdIsCorrect() {
        Department department = departmentRepository.findById(1L).orElseThrow();
        assertEquals("IT", department.getName());
    }

}
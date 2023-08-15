package com.example.spring_boot_tutorial;

import com.example.spring_boot_tutorial.dto.DepartmentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .id(1L)
                .name("IT")
                .address("Katowice")
                .code("C123")
                .build();
        Mockito.when(departmentRepository.findDepartmentByNameIgnoreCase("IT"))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Get data based on a valid department name")
    public void shouldReturnDepartmentIfDepartmentNameIsCorrect() {
        String departmentName = "IT";
        DepartmentResponse department = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, department.getName());
    }
}
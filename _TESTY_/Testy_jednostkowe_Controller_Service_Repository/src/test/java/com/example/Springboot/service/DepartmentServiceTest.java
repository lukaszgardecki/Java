package com.example.Springboot.service;

import com.example.Springboot.entity.Department;
import com.example.Springboot.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentAddress("Katowice")
                .departmentCode("A23")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void shouldFindDepartmentName() {
        String departmentName = "IT";
        Department department = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, department.getDepartmentName());
    }

}
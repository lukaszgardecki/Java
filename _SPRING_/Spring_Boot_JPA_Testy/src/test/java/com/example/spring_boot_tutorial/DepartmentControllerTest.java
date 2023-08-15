package com.example.spring_boot_tutorial;

import com.example.spring_boot_tutorial.dto.DepartmentRequest;
import com.example.spring_boot_tutorial.dto.DepartmentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private DepartmentResponse departmentResponse;


    @BeforeEach
    void setUp() {
        departmentResponse = DepartmentResponse.builder()
                .id(1L)
                .name("IT")
                .address("Katowice")
                .code("C123")
                .build();
    }

    @Test
    void shouldSaveDepartment() throws Exception {
        DepartmentRequest departmentRequest = DepartmentRequest.builder()
                .name("IT")
                .address("Katowice")
                .code("C123")
                .build();

        Mockito.when(departmentService.saveDepartment(departmentRequest))
                .thenReturn(departmentResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name":"IT",
                                "address":"Katowice",
                                "code":"C123"
                                }""")
                )
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldFetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(departmentResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(departmentResponse.getName()));
    }
}
package com.example.spring_boot_tutorial;

import com.example.spring_boot_tutorial.dto.DepartmentRequest;
import com.example.spring_boot_tutorial.dto.DepartmentResponse;
import com.example.spring_boot_tutorial.error.DepartmentNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentResponse saveDepartment(DepartmentRequest department) {
        Department departmentToSave = mapToEntity(department);
        Department savedDepartment = repository.save(departmentToSave);
        DepartmentResponse departmentResponse = mapToResponseDTO(savedDepartment);
        return departmentResponse;
    }

    public List<DepartmentResponse> fetchDepartmentList() {
        return repository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public DepartmentResponse fetchDepartmentById(Long departmentId) {
        return repository.findById(departmentId)
                .map(this::mapToResponseDTO)
                .orElseThrow(DepartmentNotFoundException::new);
    }

    public DepartmentResponse fetchDepartmentByName(String name) {
        return repository.findDepartmentByNameIgnoreCase(name)
                .map(this::mapToResponseDTO)
                .orElseThrow();
    }

    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Transactional
    public DepartmentResponse updateDepartmentById(Long departmentId, DepartmentRequest department) {
        Department d = repository.findById(departmentId)
                .orElseThrow();
        if (Objects.equals(d.getId(), departmentId)) {
             d.setName(department.getName());
             d.setAddress(department.getAddress());
             d.setCode(department.getCode());
        }
        return mapToResponseDTO(d);
    }

    private DepartmentResponse mapToResponseDTO(Department department) {
        DepartmentResponse response = new DepartmentResponse();
        response.setId(department.getId());
        response.setName(department.getName());
        response.setAddress(department.getAddress());
        response.setCode(department.getCode());
        return response;
    }

    private Department mapToEntity(DepartmentRequest department) {
        Department entity = new Department();
        entity.setName(department.getName());
        entity.setAddress(department.getAddress());
        entity.setCode(department.getCode());
        return entity;
    }
}

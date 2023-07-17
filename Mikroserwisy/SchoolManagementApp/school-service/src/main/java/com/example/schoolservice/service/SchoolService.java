package com.example.schoolservice.service;

import com.example.schoolservice.entity.School;
import com.example.schoolservice.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;


    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElseThrow();
    }

    public School updateSchool(Long id, School school) {
        School existingSchool = schoolRepository.findById(id).orElseThrow();
        existingSchool.setName(school.getName());
        existingSchool.setAddress(school.getAddress());
        return schoolRepository.save(existingSchool);
    }

    public void deleteSchoolById(Long id) {
        schoolRepository.deleteById(id);
    }
}

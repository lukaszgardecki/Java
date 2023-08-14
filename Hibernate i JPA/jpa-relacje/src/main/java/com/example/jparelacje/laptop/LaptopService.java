package com.example.jparelacje.laptop;

import com.example.jparelacje.laptop.dto.LaptopRequest;
import com.example.jparelacje.laptop.dto.LaptopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public LaptopResponse saveLaptop(LaptopRequest studentRequest) {
        Laptop laptopToSave = getLaptopFromRequest(studentRequest);
        Laptop savedLaptop = laptopRepository.save(laptopToSave);
        LaptopResponse studentResponse = getLaptopResponseFromLaptop(savedLaptop);
        return studentResponse;
    }

    public List<LaptopResponse> findAllLaptops() {
        return laptopRepository.findAll().stream()
                .map(this::getLaptopResponseFromLaptop)
                .toList();
    }

    public Optional<LaptopResponse> findLaptopById(Long id) {
        return laptopRepository.findById(id)
                .map(this::getLaptopResponseFromLaptop);
    }

    private LaptopResponse getLaptopResponseFromLaptop(Laptop savedLaptop) {
        return LaptopResponse.builder()
                .id(savedLaptop.getId())
                .modelNumber(savedLaptop.getModelNumber())
                .brand(savedLaptop.getBrand())
                .build();
    }

    private Laptop getLaptopFromRequest(LaptopRequest studentRequest) {
        return Laptop.builder()
                .modelNumber(studentRequest.getModelNumber())
                .brand(studentRequest.getBrand())
                .build();
    }


}

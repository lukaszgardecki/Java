package com.example.addressapp.service;

import com.example.addressapp.dto.AddressResponse;
import com.example.addressapp.mapper.AddressMapper;
import com.example.addressapp.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Optional<AddressResponse> getAddressByEmployeeId(Long id) {
        return addressRepository.findAddressByEmployeeId(id)
                .map(AddressMapper::map);
    }
}

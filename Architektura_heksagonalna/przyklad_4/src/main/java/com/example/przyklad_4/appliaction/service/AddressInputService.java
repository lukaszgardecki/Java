package com.example.przyklad_4.appliaction.service;

import com.example.przyklad_4.appliaction.dto.AddressDTO;
import com.example.przyklad_4.domain.address.AddressEntity;
import com.example.przyklad_4.domain.address.port.port.AddressRepositoryInputPort;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class AddressInputService {
    private final AddressRepositoryInputPort addressRepositoryInputPort;

    public Long createAddress(AddressDTO dto) {
        AddressEntity address;
        if (Objects.nonNull(dto.getFlatNumber())) {
            address = new AddressEntity(
                    dto.getStreetName(),
                    dto.getStreetNumber(),
                    dto.getFlatNumber(),
                    dto.getPostalCode(),
                    dto.getCountry(),
                    dto.getCity()
            );
        }
        // TODO: 06.12.2024 tu brakuje kodu

        return addressRepositoryInputPort.save(address).getId();
    }
}

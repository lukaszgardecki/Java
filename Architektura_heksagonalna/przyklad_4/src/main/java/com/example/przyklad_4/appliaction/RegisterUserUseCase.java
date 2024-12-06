package com.example.przyklad_4.appliaction;

import com.example.przyklad_4.appliaction.dto.RegisterUserDTO;
import com.example.przyklad_4.appliaction.service.AddressInputService;
import com.example.przyklad_4.domain.user.port.UserEntity;
import com.example.przyklad_4.domain.user.port.UserRepositoryInputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class RegisterUserUseCase {
    private final UserRepositoryInputPort userRepositoryInputPort;
    private final AddressInputService addressInputService;

    @Transactional
    public UUID execute(RegisterUserDTO dto) {
        Long addressId = addressInputService.createAddress(
                dto.getAddress()
        );
        UserEntity user = createUser(dto);
        user.linkAddressToUser(addressId);
        userRepositoryInputPort.save(user);
        return user.getUuid();
    }

    private UserEntity createUser(RegisterUserDTO dto) {
        return new UserEntity(
                dto.getUuid(),
                dto.getRealAmount(),
                dto.getFreeAmount()
        );
    }
}

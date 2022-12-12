package com.example.validation;

import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    Client map(ClientDto dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(dto.getEmail());
        client.setAge(dto.getAge());
        return client;
    }
}

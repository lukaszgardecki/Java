package com.example.addressapp.mapper;

import com.example.addressapp.dto.AddressResponse;
import com.example.addressapp.entity.Address;

public class AddressMapper {

    public static AddressResponse map(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .lane1(address.getLane1())
                .lane2(address.getLane2())
                .zip(address.getZip())
                .state(address.getState())
                .build();
    }
}

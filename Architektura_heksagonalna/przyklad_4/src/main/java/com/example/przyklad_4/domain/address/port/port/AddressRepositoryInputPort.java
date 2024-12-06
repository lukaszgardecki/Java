package com.example.przyklad_4.domain.address.port.port;

import com.example.przyklad_4.domain.address.AddressEntity;

public interface AddressRepositoryInputPort {

    AddressEntity save(AddressEntity address);
}

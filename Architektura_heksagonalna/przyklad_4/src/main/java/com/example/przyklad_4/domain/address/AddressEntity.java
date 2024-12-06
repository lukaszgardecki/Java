package com.example.przyklad_4.domain.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    @Id
    private Long id;
    private String streetName;
    private String streetNumber;
    private String flatNumber;
    private String postalCode;
    private String country;
    private String city;

    public AddressEntity(String streetName, String streetNumber, String flatNumber, String postalCode, String country, String city) {
    }
}

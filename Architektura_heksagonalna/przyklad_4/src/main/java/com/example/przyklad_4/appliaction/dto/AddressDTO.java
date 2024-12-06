package com.example.przyklad_4.appliaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDTO {
    private String streetName;
    private String streetNumber;
    private String flatNumber;
    private String postalCode;
    private String country;
    private String city;
}

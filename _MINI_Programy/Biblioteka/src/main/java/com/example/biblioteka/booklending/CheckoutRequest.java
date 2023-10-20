package com.example.biblioteka.booklending;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutRequest {
    private Long userId;
    private String bookBarcode;
}

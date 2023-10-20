package com.example.biblioteka.bookreservation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReservationCancellationRequest {
    private Long userId;
    private String bookBarcode;
}

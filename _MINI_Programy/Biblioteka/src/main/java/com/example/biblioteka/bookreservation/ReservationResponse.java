package com.example.biblioteka.bookreservation;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class ReservationResponse {
    private Long id;
    private LocalDate creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private Long memberId;
}

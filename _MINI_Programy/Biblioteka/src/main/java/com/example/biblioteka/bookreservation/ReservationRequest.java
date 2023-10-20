package com.example.biblioteka.bookreservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {
    private Long userId;
    private Long bookId;
}

package com.example.biblioteka.booklending;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class LendingDto {
    private Long id;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LendingStatus status;
    private Long memberId;
    private String bookBarcode;
}

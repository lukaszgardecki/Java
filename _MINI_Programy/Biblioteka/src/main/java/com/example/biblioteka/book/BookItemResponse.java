package com.example.biblioteka.book;

import com.example.biblioteka.Rack;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class BookItemResponse {
    private Long id;
    private String barcode;
    private boolean isReferenceOnly;
    private LocalDate borrowed;
    private LocalDate dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private LocalDate dateOfPurchase;
    private LocalDate publicationDate;
    private Rack placedAt;
}

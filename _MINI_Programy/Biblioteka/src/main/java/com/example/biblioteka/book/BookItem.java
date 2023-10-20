package com.example.biblioteka.book;

import com.example.biblioteka.Rack;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class BookItem extends Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void updateBookItemStatus(BookStatus bookStatus) {
        status = bookStatus;
    }

    public void updateDueDate(LocalDate localDate) {
        dueDate = localDate;
    }
}

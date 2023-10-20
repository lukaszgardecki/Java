package com.example.biblioteka.book;

import com.example.biblioteka.booklending.LendingDto;
import com.example.biblioteka.booklending.CheckoutRequest;
import com.example.biblioteka.bookreservation.ReservationRepository;
import com.example.biblioteka.exception.CheckoutException;
import com.example.biblioteka.exception.RenewBookException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookItemService {
    private final BookItemRepository bookItemRepository;
    private final ReservationRepository reservationRepository;

    public BookItemResponse getBookById(Long id) {
        BookItem book = findBookById(id);
        return toBookItemResponse(book);
    }

    public void returnABook(String bookBarcode) {
        BookItem book = findBookByBarcode(bookBarcode);
        boolean bookIsReserved = isBookReserved(bookBarcode);
        if (bookIsReserved) {
            book.setStatus(BookStatus.RESERVED);
        } else {
            book.setStatus(BookStatus.AVAILABLE);
        }
    }

    public void renewABook(LendingDto bookLending) {
        BookItem book = findBookByBarcode(bookLending.getBookBarcode()); // ????
        boolean bookIsReserved = isBookReserved(bookLending.getBookBarcode());
        if (bookIsReserved) {
            throw new RenewBookException("The book is reserved and cannot be renewed");
        } else {
            book.setDueDate(LocalDate.now());
        }
    }

    public void updateBookAfterCheckout(LendingDto bookLending) {
        BookItem book = findBookByBarcode(bookLending.getBookBarcode());
        book.setBorrowed(bookLending.getCreationDate());
        book.setDueDate(bookLending.getDueDate());
        book.updateBookItemStatus(BookStatus.LOANED);
    }

    public void checkIfBookCanBeBorrowed(CheckoutRequest request) {
        BookItem book = findBookByBarcode(request.getBookBarcode());
        if(book.isReferenceOnly()) {
            throw new CheckoutException("This book is Reference only and can't be issued");
        }
    }

    private boolean isBookReserved(String bookBarcode) {
        return reservationRepository.findAllPendingReservations(bookBarcode).size() > 0;
    }

    private BookItem findBookById(Long id) {
        return bookItemRepository.findById(id)
                .orElseThrow();
    }

    private BookItem findBookByBarcode(String barcode) {
        return bookItemRepository.findByBarcode(barcode)
                .orElseThrow();
    }

    private BookItemResponse toBookItemResponse(BookItem book) {
        return BookItemResponse.builder()
                .id(book.getId())
                .barcode(book.getBarcode())
                .isReferenceOnly(book.isReferenceOnly())
                .borrowed(book.getBorrowed())
                .dueDate(book.getDueDate())
                .price(book.getPrice())
                .format(book.getFormat())
                .status(book.getStatus())
                .dateOfPurchase(book.getDateOfPurchase())
                .publicationDate(book.getPublicationDate())
                .placedAt(book.getPlacedAt())
                .build();
    }
}

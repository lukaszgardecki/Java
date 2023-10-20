package com.example.biblioteka.bookreservation;

import com.example.biblioteka.book.*;
import com.example.biblioteka.booklending.CheckoutRequest;
import com.example.biblioteka.exception.CheckoutException;
import com.example.biblioteka.exception.ReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookItemRepository bookItemRepository;

//    public ReservationResponse getReservation(CheckoutRequest request) {
//        return findReservation(request)
//                .map(this::createReservationResponse)
//                .orElseThrow();
//    }

    public ReservationResponse makeAReservation(ReservationRequest request) {
        BookItem book = bookItemRepository.findById(request.getBookId())
                .orElseThrow();
        checkStatusToReservation(book);
        boolean reservationDoesNotExist = !doesReservationExist(request.getUserId(), book.getBarcode());

        if (reservationDoesNotExist) {
            Reservation reservationToSave = createReservation(request.getUserId(), book.getBarcode());
            Reservation savedReservation = reservationRepository.save(reservationToSave);
            return createReservationResponse(savedReservation);
        } else throw new ReservationException("The reservation has already been created.");
    }

    public ReservationResponse cancelAReservation(ReservationCancellationRequest request) {
        BookItem book = findBookByBarcode(request.getBookBarcode());
        Reservation reservation = findReservation(request.getUserId(), request.getBookBarcode());
        boolean bookHasNoOtherReservations = isBookReservedBySomeoneElse(request.getUserId(), book.getBarcode());
        if (bookHasNoOtherReservations) {
            book.setStatus(BookStatus.AVAILABLE);
        }
        reservation.setStatus(ReservationStatus.CANCELED);
        return createReservationResponse(reservation);
    }

    public void completeReservation(CheckoutRequest request) {
        Reservation reservation = findReservation(request.getUserId(), request.getBookBarcode());
        checkStatusToCheckout(reservation);
        completeReservation(reservation);
    }

    public boolean isBookReservedBySomeoneElse(String bookBarcode) {
        return getAllPendingReservations(bookBarcode).size() > 0;
    }

    // TODO: 19.10.2023 czy wszystkie poniższe metody są potrzebne? Czy nie jest ich za dużo?

    private Reservation findReservation(Long memberId, String bookBarcode) {
        return reservationRepository.findAllByMemberIdAndBookItemBarcode(memberId, bookBarcode)
                .stream()
                .filter(res -> res.getStatus() == ReservationStatus.PENDING || res.getStatus() == ReservationStatus.WAITING)
                .findAny()
                .orElseThrow();
    }

    private BookItem findBookByBarcode(String bookBarcode) {
        return bookItemRepository.findByBarcode(bookBarcode)
                .orElseThrow();
    }

    private boolean isBookReservedBySomeoneElse(Long memberId, String bookBarcode) {
        return getAllPendingReservations(bookBarcode).stream()
                .anyMatch(res -> !Objects.equals(res.getMemberId(), memberId));
    }

    private boolean doesReservationExist(Long memberId, String bookBarcode) {
        return getAllPendingReservations(bookBarcode).stream()
                .anyMatch(res -> Objects.equals(res.getMemberId(), memberId));
    }

    private List<Reservation> getAllPendingReservations(String bookBarcode) {
        return reservationRepository.findAllPendingReservations(bookBarcode);
    }

    private void completeReservation(Reservation reservation) {
        reservation.setStatus(ReservationStatus.COMPLETED);
    }

    private void checkStatusToReservation(BookItem book) {
        if (book.getStatus() == BookStatus.LOST) throw new ReservationException("Book cannot be reserved");
        if (book.getStatus() == BookStatus.AVAILABLE) book.setStatus(BookStatus.RESERVED);
    }

    private void checkStatusToCheckout(Reservation reservation) {
        boolean bookIsNotReady = reservation.getStatus() != ReservationStatus.WAITING;
        if (bookIsNotReady) throw new CheckoutException("Book is not ready");
    }

    private Reservation createReservation(Long memberId, String bookBarcode) {
        return Reservation.builder()
                .creationDate(LocalDate.now())
                .status(ReservationStatus.PENDING)
                .bookBarcode(bookBarcode)
                .memberId(memberId)
                .build();
    }

    private ReservationResponse createReservationResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .creationDate(reservation.getCreationDate())
                .status(reservation.getStatus())
                .bookItemBarcode(reservation.getBookBarcode())
                .memberId(reservation.getMemberId())
                .build();
    }
}

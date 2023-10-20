package com.example.biblioteka;

import com.example.biblioteka.account.MemberService;
import com.example.biblioteka.book.BookItemService;
import com.example.biblioteka.booklending.CheckoutRequest;
import com.example.biblioteka.booklending.LendingDto;
import com.example.biblioteka.booklending.LendingService;
import com.example.biblioteka.bookreservation.ReservationCancellationRequest;
import com.example.biblioteka.bookreservation.ReservationRequest;
import com.example.biblioteka.bookreservation.ReservationResponse;
import com.example.biblioteka.bookreservation.ReservationService;
import com.example.biblioteka.fine.FineService;
import com.example.biblioteka.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagementService {
    private final BookItemService bookItemService;
    private final FineService fineService;
    private final ReservationService reservationService;
    private final MemberService memberService;
    private final LendingService lendingService;
    private final NotificationService notificationService;

    public void reserveABook(ReservationRequest request) {
        memberService.checkReservationsLimit(request.getUserId());
        ReservationResponse reservation = makeAReservation(request);
        memberService.updateMemberAfterReservation(reservation);
        notificationService.sendReservationCreatedNotification();

        /*jeżeli ksiązka jest wypożyczona to wyślij powiadomienie
        * do wypożyczającego o nie możliwości przedłużenia ksiązki*/
    }

    public void cancelReservation(ReservationCancellationRequest request) {
        ReservationResponse reservation = cancelAReservation(request);
        memberService.updateMemberAfterReservationCancelling(reservation);
        notificationService.sendReservationCancelledNotification();
    }

    public void checkout(CheckoutRequest request) {
        memberService.checkIssuedBooksLimit(request.getUserId());
        fineService.checkMemberForFee(request.getUserId());
        reservationService.completeReservation(request);
        bookItemService.checkIfBookCanBeBorrowed(request);
        LendingDto lending = lendTheBook(request);
        bookItemService.updateBookAfterCheckout(lending);
        memberService.updateMemberAfterCheckout(lending);
        notificationService.sendBookIssuedNotification();
    }

    public void returnABook(String bookBarcode) {
        LendingDto lending = lendingService.getCurrentLending(bookBarcode);
        fineService.checkBookForFee(lending.getDueDate());
        bookItemService.returnABook(bookBarcode);
        memberService.updateMemberAfterReturning(lending.getMemberId());
        lendingService.updateLendingAfterReturning(bookBarcode);
        notificationService.sendBookAvailableNotification();
    }

    public void renewABook(String bookBarcode) {
        LendingDto lending = lendingService.getCurrentLending(bookBarcode);
        fineService.checkBookForFee(lending.getDueDate());
        bookItemService.renewABook(lending);
        lendingService.updateLendingAfterRenewing(bookBarcode);
        notificationService.sendBookHasRenewedNotification();
    }

    // TODO: 19.10.2023 spłać karę
    public void payFine(String bookBarcode) {
        fineService.payFine(bookBarcode);

    }

    // TODO: 19.10.2023 zgłoś zgubę ksiązki + obciąż

    private ReservationResponse makeAReservation(ReservationRequest request) {
        return reservationService.makeAReservation(request);
    }

    private ReservationResponse cancelAReservation(ReservationCancellationRequest request) {
        return reservationService.cancelAReservation(request);
    }

    private LendingDto lendTheBook(CheckoutRequest request) {
        return lendingService.lendBook(request);
    }
}

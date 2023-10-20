package com.example.biblioteka.account;

import com.example.biblioteka.Constants;
import com.example.biblioteka.booklending.LendingDto;
import com.example.biblioteka.bookreservation.ReservationResponse;
import com.example.biblioteka.exception.BookLimitException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

//    public boolean renewBookItem(RenewBookRequest request) {
//        Member user = memberRepository.findById(request.getUserId())
//                .orElseThrow();
//        BookItem book = bookItemRepository.findById(request.getBookId())
//                .orElseThrow();
//
//
//        checkForFine(book.getBarcode());
////        BookReservation bookReservation = reservationService.fetchReservationDetails(book.getBarcode());
//
//        reservationService.checkReservation(book, user);
//
//
//        lendingService.lendBook(book, user);
//        book.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
//        return true;
//    }

    public MemberResponse getMemberById(Long userId) {
        return memberRepository.findById(userId)
                .map(this::toMemberResponse)
                .orElseThrow();
    }

    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }

    public void checkReservationsLimit(Long memberId) {
        Member member = findMemberById(memberId);
        if (member.getTotalBooksReserved() >= Constants.MAX_BOOKS_RESERVED_BY_USER) {
            throw new BookLimitException("The user has already reserved maximum number of books");
        }
    }

    public void checkIssuedBooksLimit(Long memberId) {
        Member member = findMemberById(memberId);
        if (member.getTotalBooksCheckedout() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            throw new BookLimitException("The maximum number of books has been issued to the user");
        }
    }

    public void updateMemberAfterCheckout(LendingDto bookLending) {
        Member member = findMemberById(bookLending.getMemberId());
        member.incrementTotalBooksCheckedout();
        member.decrementTotalBooksReserved();
    }

    public void updateMemberAfterReservation(ReservationResponse reservation) {
        Member member = findMemberById(reservation.getMemberId());
        member.incrementTotalBooksReserved();
    }

    private MemberResponse toMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .dateOfMembership(member.getDateOfMembership())
                .totalBooksReserved(member.getTotalBooksReserved())
                .totalBooksCheckedout(member.getTotalBooksCheckedout())
                .build();
    }

    public void updateMemberAfterReservationCancelling(ReservationResponse reservation) {
        Member member = findMemberById(reservation.getMemberId());
        member.decrementTotalBooksReserved();
    }

    public void updateMemberAfterReturning(Long memberId) {
        Member member = findMemberById(memberId);
        member.decrementTotalBooksCheckedout();
    }
}

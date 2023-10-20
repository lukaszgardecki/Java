package com.example.biblioteka.booklending;

import com.example.biblioteka.Constants;
import com.example.biblioteka.book.BookItem;
import com.example.biblioteka.book.BookItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LendingService {
    private final LendingRepository lendingRepository;
    private final BookItemRepository bookItemRepository;

    // TODO: 06.10.2023 przy zwrocie trzeba ustawić date zwrotu w BookLending


    public LendingDto lendBook(CheckoutRequest request) {
        Lending lending = createBookLending(request);
        Lending savedLanding = lendingRepository.save(lending);
        return mapToDto(savedLanding);
    }

    public LendingDto getCurrentLending(String bookBarcode) {
        return lendingRepository.findCurrentLendingByBarcode(bookBarcode)
                .map(this::mapToDto)
                .orElseThrow();
    }

    public void updateLendingAfterReturning(String bookBarcode) {
        Lending lending = findCurrentLending(bookBarcode);
        lending.setReturnDate(LocalDate.now());
        lending.setStatus(LendingStatus.COMPLETED);
    }

    public void updateLendingAfterRenewing(String bookBarcode) {
        Lending lending = findCurrentLending(bookBarcode);
        lending.setReturnDate(LocalDate.now());
    }

    private Lending findCurrentLending(String bookBarcode) {
        return lendingRepository.findCurrentLendingByBarcode(bookBarcode)
                .orElseThrow();
    }

    private LendingDto mapToDto(Lending savedLanding) {
        return LendingDto.builder()
                .id(savedLanding.getId())
                .creationDate(savedLanding.getCreationDate())
                .dueDate(savedLanding.getDueDate())
                .returnDate(savedLanding.getReturnDate())
                .status(savedLanding.getStatus())
                .memberId(savedLanding.getMemberId())
                .bookBarcode(savedLanding.getBookBarcode())
                .build();
    }

    private Lending createBookLending(CheckoutRequest request) {
        LocalDate nowDate = LocalDate.now();
        LocalDate dueDate = nowDate.plusDays(Constants.MAX_LENDING_DAYS);
        return Lending.builder()
                .creationDate(nowDate)
                .dueDate(dueDate)
                .status(LendingStatus.CURRENT)
                .memberId(request.getUserId())
                .bookBarcode(request.getBookBarcode())
                .build();
    }
}

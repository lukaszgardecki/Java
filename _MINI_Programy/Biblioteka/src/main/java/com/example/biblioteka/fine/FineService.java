package com.example.biblioteka.fine;

import com.example.biblioteka.booklending.Lending;
import com.example.biblioteka.booklending.LendingRepository;
import com.example.biblioteka.booklending.LendingStatus;
import com.example.biblioteka.exception.UnsettledFineException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class FineService {
    public static double DAY_FINE = 0.2;
    private final LendingRepository lendingRepository;

    public void checkMemberForFee(Long memberId) {
        LocalDate now = LocalDate.now();
        double totalFine = lendingRepository.findAllByMemberId(memberId).stream()
                .filter(len -> len.getStatus() == LendingStatus.CURRENT)
                .filter(len -> now.isAfter(len.getDueDate()))
                .mapToDouble(len -> countFine(len.getDueDate(), now))
                .sum();
        validateTotalFee(totalFine);
    }

    public void checkBookForFee(LocalDate dueDate) {
        LocalDate now = LocalDate.now();
        double totalFee = countFine(dueDate, now);
        validateTotalFee(totalFee);
    }

    public double payFine(String bookBarcode) {
        Lending lending = lendingRepository.findCurrentLendingByBarcode(bookBarcode)
                .orElseThrow();
        LocalDate now = LocalDate.now();
        LocalDate dueDate = lending.getDueDate();
        double fine = countFine(dueDate, now);
        lending.setDueDate(LocalDate.now());
        return fine;
    }

    private double countFine(LocalDate dueDate, LocalDate now) {
        long diffDays = getDaysBetween(dueDate, now);
        return diffDays * DAY_FINE;
    }

    private void validateTotalFee(double totalFee) {
        if (totalFee > 0.0) throw new UnsettledFineException("Fee: " + totalFee);
    }

    private long getDaysBetween(LocalDate dueDate, LocalDate now) {
        return ChronoUnit.DAYS.between(dueDate, now);
    }
}

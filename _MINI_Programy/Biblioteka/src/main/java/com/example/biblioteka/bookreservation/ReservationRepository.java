package com.example.biblioteka.bookreservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByBookItemBarcode(String barcode);

    List<Reservation> findAllByMemberIdAndBookItemBarcode(Long memberId, String bookBarcode);

    @Query(
            value = """
            select * from Reservation
            where book_barcode = :bookBarcode
            and status = 'PENDING'
            """,
            nativeQuery = true
    )
    List<Reservation> findAllPendingReservations(String bookBarcode);
}

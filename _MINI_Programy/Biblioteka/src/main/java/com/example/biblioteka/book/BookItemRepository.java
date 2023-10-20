package com.example.biblioteka.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookItemRepository extends JpaRepository<BookItem, Long> {

    List<BookItem> findAllByTitleContainsIgnoreCase(String title);

    List<BookItem> findAllBy(String author);

    List<BookItem> findAllBySubjectContainsIgnoreCase(String subject);

    List<BookItem> findAllByPublicationDate(LocalDate date);

    Optional<BookItem> findByBarcode(String bookBarcode);
}

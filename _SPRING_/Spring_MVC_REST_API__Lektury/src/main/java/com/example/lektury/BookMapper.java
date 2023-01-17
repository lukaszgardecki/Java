package com.example.lektury;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    static BookDto map(Book book) {
        return new BookDto(
                book.getKind(),
                book.getFullSortKey(),
                book.getTitle(),
                book.getUrl(),
                book.getCoverColor(),
                book.getAuthor(),
                book.getCover(),
                book.getEpoch(),
                book.getHref(),
                book.getHasAudio(),
                book.getGenre(),
                book.getSimpleThumb(),
                book.getSlug(),
                book.getCoverThumb(),
                book.getLiked()
        );
    }

    static Book map(BookDto dto) {
        return new Book(
                dto.getKind(),
                dto.getFullSortKey(),
                dto.getTitle(),
                dto.getUrl(),
                dto.getCoverColor(),
                dto.getAuthor(),
                dto.getCover(),
                dto.getEpoch(),
                dto.getHref(),
                dto.getHasAudio(),
                dto.getGenre(),
                dto.getSimpleThumb(),
                dto.getSlug(),
                dto.getCoverThumb(),
                dto.getLiked()
        );
    }
}

package com.example.lektury;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BooksService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BooksService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookDto[] getBooks() {
        RestTemplate rest = new RestTemplate();
        URI uri = URI.create("https://wolnelektury.pl/api/books/");

        ResponseEntity<BookDto[]> exchange = rest.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, BookDto[].class);
        return exchange.getBody();
    }

    public void saveAll(BookDto[] books) {
        List<Book> collect = Arrays.stream(books)
                .map(BookMapper::map)
                .toList();
        bookRepository.saveAll(collect);
    }
}

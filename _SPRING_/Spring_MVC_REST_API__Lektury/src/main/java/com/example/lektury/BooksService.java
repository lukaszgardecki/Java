package com.example.lektury;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BooksService {

    public Book[] getBooks() {
        RestTemplate rest = new RestTemplate();
        URI uri = URI.create("https://wolnelektury.pl/api/books/");

        ResponseEntity<Book[]> exchange = rest.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, Book[].class);
        return exchange.getBody();
    }
}

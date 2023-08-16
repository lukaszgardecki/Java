package com.example.jparelacje2.web;

import com.example.jparelacje2.domain.book.BookRequestDto;
import com.example.jparelacje2.domain.book.BookResponseDto;
import com.example.jparelacje2.domain.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto request) {
        BookResponseDto savedBook = bookService.addBook(request);

        URI savedBookURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        return ResponseEntity.created(savedBookURI).body(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        BookResponseDto book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable Long id) {
        BookResponseDto deletedBook = bookService.deletebook(id);
        return ResponseEntity.ok(deletedBook);
    }

    @PostMapping("/{id}")
    public ResponseEntity<BookResponseDto> editBook(@PathVariable Long id, @RequestBody BookRequestDto request) {
        BookResponseDto editedBook = bookService.editBook(id, request);
        return ResponseEntity.ok(editedBook);
    }

    @PostMapping("/{bookId}/addAuthor/{authorId}")
    public ResponseEntity<BookResponseDto> addAuthorToBook(@PathVariable Long bookId, @PathVariable Long authorId) {
        BookResponseDto book = bookService.addAuthorToBook(bookId, authorId);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/{bookId}/removeAuthor/{authorId}")
    public ResponseEntity<BookResponseDto> removeAuthorToBook(@PathVariable Long bookId, @PathVariable Long authorId) {
        BookResponseDto book = bookService.removeAuthorFromBook(bookId, authorId);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/{bookId}/addCategory/{categoryId}")
    public ResponseEntity<BookResponseDto> addCategoryToBook(@PathVariable Long bookId, @PathVariable Long categoryId) {
        BookResponseDto book = bookService.addCategoryToBook(bookId, categoryId);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/{bookId}/removeCategory/{categoryId}")
    public ResponseEntity<BookResponseDto> removeCategoryToBook(@PathVariable Long bookId, @PathVariable Long categoryId) {
        BookResponseDto book = bookService.removeCategoryFromBook(bookId, categoryId);
        return ResponseEntity.ok(book);
    }




}

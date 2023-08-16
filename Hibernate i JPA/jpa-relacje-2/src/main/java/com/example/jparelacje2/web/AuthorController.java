package com.example.jparelacje2.web;

import com.example.jparelacje2.domain.author.AuthorRequestDto;
import com.example.jparelacje2.domain.author.AuthorResponseDto;
import com.example.jparelacje2.domain.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto reuquest) {
        AuthorResponseDto savedAuthor = authorService.addAuthor(reuquest);

        URI savedAuthorURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAuthor.getId())
                .toUri();

        return ResponseEntity.created(savedAuthorURI).body(savedAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id) {
        AuthorResponseDto author = authorService.getAuthor(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        List<AuthorResponseDto> allAuthors = authorService.getAllAuthors();
        return ResponseEntity.ok(allAuthors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable Long id) {
        AuthorResponseDto removedAuthor = authorService.deleteAuthor(id);
        return ResponseEntity.ok(removedAuthor);
    }

    @PostMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable Long id, @RequestBody AuthorRequestDto request) {
        AuthorResponseDto editedAuthor = authorService.editAuthor(id, request);
        return ResponseEntity.ok(editedAuthor);
    }

    @PostMapping("/{authorId}/addZipcode/{zipcodeId}")
    public ResponseEntity<AuthorResponseDto> addZipcodeToAuthor(@PathVariable Long authorId, @PathVariable Long zipcodeId) {
        AuthorResponseDto author = authorService.addZipcodeToAuthor(authorId, zipcodeId);
        return ResponseEntity.ok(author);
    }

    @PostMapping("/{authorId}/removeZipcode")
    public ResponseEntity<AuthorResponseDto> removeZipcodeToAuthor(@PathVariable Long authorId) {
        AuthorResponseDto author = authorService.removeZipcodeFromAuthor(authorId);
        return ResponseEntity.ok(author);
    }
}


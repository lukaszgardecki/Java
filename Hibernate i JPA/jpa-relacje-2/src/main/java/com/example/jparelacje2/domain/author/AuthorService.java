package com.example.jparelacje2.domain.author;

import com.example.jparelacje2.Mapper;
import com.example.jparelacje2.domain.zipcode.Zipcode;
import com.example.jparelacje2.exception.AuthorCreateException;
import com.example.jparelacje2.exception.AuthorNotFoundException;
import com.example.jparelacje2.exception.ZipcodeNotFoundException;
import com.example.jparelacje2.domain.zipcode.ZipcodeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final ZipcodeRepository zipcodeRepository;

    @Transactional
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author authorToSave = new Author();
        authorToSave.setName(authorRequestDto.getName());
        if (authorRequestDto.getZipcodeId() == null) {
            throw new AuthorCreateException("Author needs a zipcode");
        }
        Zipcode zipcode = findZipcodeById(authorRequestDto.getZipcodeId());
        authorToSave.setZipcode(zipcode);
        Author savedAuthor = authorRepository.save(authorToSave);
        return Mapper.mapAuthorToAuthorResponseDto(savedAuthor);
    }

    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(Mapper::mapAuthorToAuthorResponseDto)
                .toList();
    }

    public AuthorResponseDto getAuthor(Long authorId) {
        Author author = findAuthorById(authorId);
        return Mapper.mapAuthorToAuthorResponseDto(author);
    }

    @Transactional
    public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
        Author authorToUpdate = findAuthorById(authorId);
        authorToUpdate.setName(authorRequestDto.getName());
        if (authorRequestDto.getZipcodeId() != null) {
            Zipcode zipcode = findZipcodeById(authorRequestDto.getZipcodeId());
            authorToUpdate.setZipcode(zipcode);
        }
        return Mapper.mapAuthorToAuthorResponseDto(authorToUpdate);
    }

    public AuthorResponseDto deleteAuthor(Long authorId) {
        Author authorToDelete = findAuthorById(authorId);
        authorRepository.delete(authorToDelete);
        return Mapper.mapAuthorToAuthorResponseDto(authorToDelete);
    }

    @Transactional
    public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId) {
        Author author = findAuthorById(authorId);

        if (author.getZipcode() != null) {
            throw new IllegalStateException("Author already has a zipcode.");
        }
        Zipcode zipcode = findZipcodeById(zipcodeId);
        author.setZipcode(zipcode);
        return Mapper.mapAuthorToAuthorResponseDto(author);
    }

    @Transactional
    public AuthorResponseDto removeZipcodeFromAuthor(Long authorId) {
        Author author = findAuthorById(authorId);
        author.setZipcode(null);
        return Mapper.mapAuthorToAuthorResponseDto(author);
    }

    private Author findAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(AuthorNotFoundException::new);
    }

    private Zipcode findZipcodeById(Long zipcodeId) {
        return zipcodeRepository.findById(zipcodeId)
                .orElseThrow(ZipcodeNotFoundException::new);
    }
}

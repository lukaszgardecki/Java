package com.example.jparelacje2.domain.book;

import com.example.jparelacje2.Mapper;
import com.example.jparelacje2.domain.author.Author;
import com.example.jparelacje2.domain.author.AuthorRepository;
import com.example.jparelacje2.domain.category.Category;
import com.example.jparelacje2.domain.category.CategoryRepository;
import com.example.jparelacje2.exception.AuthorNotFoundException;
import com.example.jparelacje2.exception.BookNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book bookToSave = getBookToSave(bookRequestDto);
        Book savedBook = bookRepository.save(bookToSave);
        return Mapper.mapBookToBookResponseDto(savedBook);
    }

    public BookResponseDto getBook(Long bookId) {
        Book book = findBookById(bookId);
        return Mapper.mapBookToBookResponseDto(book);
    }

    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(Mapper::mapBookToBookResponseDto)
                .toList();
    }

    @Transactional
    public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto) {
        Book bookToUpdate = findBookById(bookId);
        bookToUpdate.setName(bookRequestDto.getName());
        List<Author> authors = bookRequestDto.getAuthorsIds().stream()
                .map(this::findAuthorById)
                .toList();
        bookToUpdate.setAuthors(authors);
        if (bookRequestDto.getCategoryId() != null) {
            Category category = findCategoryById(bookRequestDto.getCategoryId());
            bookToUpdate.setCategory(category);
        }
        return Mapper.mapBookToBookResponseDto(bookToUpdate);
    }

    @Transactional
    public BookResponseDto deletebook(Long bookId) {
        Book bookToDelete = findBookById(bookId);
        bookRepository.delete(bookToDelete);
        return Mapper.mapBookToBookResponseDto(bookToDelete);
    }

    @Transactional
    public BookResponseDto addAuthorToBook(Long bookId, Long authorId) {
        Book book = findBookById(bookId);
        Author author = findAuthorById(authorId);
        if (book.getAuthors().contains(author)) {
            throw new IllegalStateException("Author is already assigned to the book.");
        }
        book.addAuthor(author);
        author.addBook(book);
        return Mapper.mapBookToBookResponseDto(book);
    }

    @Transactional
    public BookResponseDto removeAuthorFromBook(Long bookId, Long authorId) {
        Book book = findBookById(bookId);
        Author author = findAuthorById(authorId);
        if (!book.getAuthors().contains(author)) {
            throw new IllegalStateException("Book does not have this author.");
        }
        book.removeAuthor(author);
        author.removeBook(book);
        return Mapper.mapBookToBookResponseDto(book);
    }

    @Transactional
    public BookResponseDto addCategoryToBook(Long bookId, Long categoryId) {
        Book book = findBookById(bookId);
        Category category = findCategoryById(categoryId);
        if (book.getCategory() != null) {
            throw new IllegalStateException("Book already has a category");
        }
        book.setCategory(category);
        category.addBook(book);
        return Mapper.mapBookToBookResponseDto(book);
    }

    @Transactional
    public BookResponseDto removeCategoryFromBook(Long bookId, Long categoryId) {
        Book book = findBookById(bookId);
        Category category = findCategoryById(categoryId);
        if (book.getCategory() != null) {
            throw new IllegalStateException("Book already has a category");
        }
        book.setCategory(null);
        category.removeBook(book);
        return Mapper.mapBookToBookResponseDto(book);
    }

    private Book getBookToSave(BookRequestDto bookRequestDto) {
        Book bookToSave = new Book();
        bookToSave.setName(bookRequestDto.getName());
        if (bookRequestDto.getAuthorsIds().isEmpty()) {
            throw new IllegalStateException("Book needs at least one author.");
        }
        List<Author> authors = bookRequestDto.getAuthorsIds().stream()
                .map(this::findAuthorById)
                .toList();
        bookToSave.setAuthors(authors);

        if (bookRequestDto.getCategoryId() == null) {
            throw new IllegalStateException("Book needs at least one category");
        }
        Category category = findCategoryById(bookRequestDto.getCategoryId());
        bookToSave.setCategory(category);
        return bookToSave;
    }

    private Book findBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);
    }

    private Author findAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(AuthorNotFoundException::new);
    }

    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow();
    }
}

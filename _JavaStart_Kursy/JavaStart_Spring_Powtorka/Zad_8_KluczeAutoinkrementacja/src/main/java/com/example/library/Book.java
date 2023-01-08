package com.example.library;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Integer pages;
    /**
     * Jeżeli korzystasz ze Spring Boota 2.7.0, lub nowszego, to ważne jest to,
     * żeby do pola year dodać adnotację @Column i wskazać inną nazwę kolumny niż year.
     * W innym przypadku H2 potraktuje "year" jako słowo kluczowe i nie uda się utworzyć tabeli.
     */
    @Column(name = "release_year")
    private Integer year;

    public Book() {
    }

    public Book(String title, String author, String publisher, Integer pages, Integer year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                '}';
    }
}

package com.example.zad_67_ksiegagosci;

public class Visit {
    private Integer id;
    private String author;
    private String text;

    public Visit(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public Visit(Integer id, String name, String text) {
        this(name, text);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("Wpis: id=%d, autor=%s, treść=%s", id, author, text);
    }
}

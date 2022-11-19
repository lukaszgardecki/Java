package com.mojastrona.zad_59_jee_chat;

public class Message {
    private String author;
    private String message;

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return author + ": " + message;
    }
}

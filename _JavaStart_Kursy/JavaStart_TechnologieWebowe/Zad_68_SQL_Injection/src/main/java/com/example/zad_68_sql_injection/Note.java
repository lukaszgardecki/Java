package com.example.zad_68_sql_injection;

public class Note {
    private Integer id;
    private String title;
    private String content;
    private String password;

    public Note(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public Note(Integer id, String title, String content, String password) {
        this(title, content, password);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

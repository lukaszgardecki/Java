package com.mojastrona.zad_55_jee_kontekstaplikacji;

public class Note {
    static final String TYPE_PUBLIC = "pub";
    static final String TYPE_PRIVATE = "priv";

    private String id;
    private String content;
    private String type;

    public Note(String id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }
}

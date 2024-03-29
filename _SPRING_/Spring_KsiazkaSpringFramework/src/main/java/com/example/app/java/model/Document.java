package com.example.app.java.model;

import java.util.Date;

public class Document {
    private String name;
    private Type type;
    private String location;
    private Date created;
    private Date modified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", location='" + location + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}

package com.example.app.link;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
    private String id;
    private String name;
    private String targetUrl;
    private long visits;
    private String password;

    public Link() {
    }

    public Link(String id, String name, String targetUrl, String password) {
        this.id = id;
        this.name = name;
        this.targetUrl = targetUrl;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public long getVisits() {
        return visits;
    }

    public void setVisits(long visits) {
        this.visits = visits;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

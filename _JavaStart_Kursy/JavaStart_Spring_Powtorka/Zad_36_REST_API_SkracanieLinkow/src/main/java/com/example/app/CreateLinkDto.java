package com.example.app;

public class CreateLinkDto {
    private String name;
    private String targetUrl;

    public CreateLinkDto(String name, String targetUrl) {
        this.name = name;
        this.targetUrl = targetUrl;
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
}

package com.mojastrona.projekt_readstack.domain.api;

public class CategoryName {
    //klasa DTO
    private Integer id;
    private String name;

    public CategoryName(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

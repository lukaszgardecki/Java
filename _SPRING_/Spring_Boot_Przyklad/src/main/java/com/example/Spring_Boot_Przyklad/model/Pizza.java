package com.example.Spring_Boot_Przyklad.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }
}

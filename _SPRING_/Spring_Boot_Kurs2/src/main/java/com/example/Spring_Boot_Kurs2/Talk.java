package com.example.Spring_Boot_Kurs2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Talk {

    @Id
    @GeneratedValue
    private String id;

    private String topic;

    public String getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }
}

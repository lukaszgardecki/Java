package com.example.mostfamousnames;

import jakarta.persistence.*;

@Entity
public class NameStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer num;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public NameStat() {
    }

    public NameStat(String name, Integer num, Gender gender) {
        this.name = name;
        this.num = num;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s. %s (%s) - %s", id, name, num, gender);
    }

    enum Gender {
        M, K
    }
}

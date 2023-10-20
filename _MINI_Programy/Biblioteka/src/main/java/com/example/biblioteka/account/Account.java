package com.example.biblioteka.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private AccountStatus status;
    @OneToOne
    private Person person;

    public abstract boolean resetPassword();
}

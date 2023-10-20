package com.example.biblioteka.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member extends Account {
    private LocalDate dateOfMembership;
    private int totalBooksCheckedout;
    private int totalBooksReserved;



    public void incrementTotalBooksCheckedout() {
        totalBooksCheckedout++;
    }

    public void decrementTotalBooksCheckedout() {
        totalBooksCheckedout--;
    }

    public void incrementTotalBooksReserved() {
        totalBooksReserved++;
    }

    public void decrementTotalBooksReserved() {
        totalBooksReserved--;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}

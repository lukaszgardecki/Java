package com.example.biblioteka.account;

import com.example.biblioteka.book.BookItem;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Member;

@Entity
@Getter
@Setter
public class Librarian extends Account {

    public  boolean addBookItem(BookItem bookItem) {

    }

    public boolean blockMember(Member member) {

    }

    public boolean unBlockMember(Member member) {

    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}

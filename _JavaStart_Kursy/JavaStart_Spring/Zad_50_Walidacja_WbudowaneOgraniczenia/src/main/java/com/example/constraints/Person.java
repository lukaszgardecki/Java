package com.example.constraints;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.pl.PESEL;

import java.time.LocalDate;

class Person {
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 2)
    private String lastName;
    @PESEL
    private String pesel;
    @Past
    private LocalDate birthday;
    @Email
    private String email;
    @NotNull
    @Size(min = 5)
    private String password;
    @URL
    private String blogUrl;

    public Person(String firstName, String lastName, String pesel, LocalDate birthday, String email, String password, String blogUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.blogUrl = blogUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
}

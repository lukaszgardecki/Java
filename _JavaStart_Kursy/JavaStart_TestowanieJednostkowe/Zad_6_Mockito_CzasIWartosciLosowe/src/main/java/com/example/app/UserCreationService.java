package com.example.app;

public class UserCreationService {
    private DateTimeProvider datetimeProvider;

    public UserCreationService(DateTimeProvider datetimeProvider) {
        this.datetimeProvider = datetimeProvider;
    }

    public User createUser(String name) {
        return new User(name, datetimeProvider.currentZonedDateTime());
    }
}

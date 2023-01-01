package com.example.app;

import java.util.UUID;

public class RandomProvider {
    public String generateRandomKey() {
        return UUID.randomUUID().toString();
    }
}

package com.example.app;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyIdGenerator {
    private static final int ID_LENGTH = 10;

    String generate() {
        List<String> id = new ArrayList<>();
        String signs = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();

        for (int i = 0; i < ID_LENGTH; i++) {
            int num = random.nextInt(signs.length());
            id.add(Character.toString(signs.charAt(num)));
            Collections.shuffle(id);
        }
        return String.join("", id);
    }
}

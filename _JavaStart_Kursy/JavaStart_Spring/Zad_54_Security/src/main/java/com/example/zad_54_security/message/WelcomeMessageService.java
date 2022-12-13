package com.example.zad_54_security.message;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageService {
    private static final String LANG_ES = "es";
    private static final String LANG_PL = "pl";

    // zdefiniowanie wiadomości powitalnej w zalezności od ustawionego języka:
    public String getWelcomeMessage(String lang) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String welcomeMessage = switch (lang) {
            case LANG_ES -> "Hola";
            case LANG_PL -> "Cześć";
            default -> "Hello";
        };
        return String.format("%s %s!", welcomeMessage, username);
    }
}

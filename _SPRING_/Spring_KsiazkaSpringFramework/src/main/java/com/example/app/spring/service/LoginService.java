package com.example.app.spring.service;

import com.example.app.java.service.Login;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements Login {
    private static final String USERNAME = "test@mydocuments.com";
    private static final String PASSWORD = "test123";

    private String username = USERNAME;
    private String password = PASSWORD;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAutorized(String email, String pass) {
        return username.equals(email) && password.equals(pass);
    }
}

package com.mojastrona.zad_50_jee_silahasla.model;

public class Password {
    private String password;

    public String get() {
        return password;
    }

    public void set(String password) {
        this.password = password;
    }

    public boolean hasMinimum5Signs() {
        return password.length() >= 5;
    }

    public boolean hasMinimum1Digit() {
        boolean ans = false;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) ans = true;
        }
        return ans;
    }

    public boolean hasMinimum1CapitalLetter() {
        boolean ans = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) ans = true;
        }
        return ans;
    }

    public boolean hasMinimum1SmallLetter() {
        boolean ans = false;
        for (char ch : password.toCharArray()) {
            if(Character.isLowerCase(ch)) ans = true;
        }
        return ans;
    }

    public boolean isOK() {
        return hasMinimum1CapitalLetter()
            && hasMinimum1SmallLetter()
            && hasMinimum1Digit()
            && hasMinimum5Signs();
    }
}

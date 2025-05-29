package com.example.leetcode.cwiczenie_58;

class Solution {
//    public int lengthOfLastWord(String s) {
//        String[] split = s.split(" ");
//        return split[split.length - 1].trim().length();
//    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = 0;
        int i = s.length() - 1; // Zaczynamy od końca stringa

        // 1. Pomiń końcowe spacje (trailing spaces)
        // Jeśli string to np. "Hello World   ", ten krok ustawi i na indeks 'd'
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Policz długość ostatniego słowa
        // Kontynuuj, dopóki nie natrafisz na spację lub nie dojdziesz do początku stringa
        while (i >= 0 && s.charAt(i) != ' ') {
            length++; // Zwiększ długość słowa
            i--;      // Przejdź do poprzedniego znaku
        }

        return length;
    }
}

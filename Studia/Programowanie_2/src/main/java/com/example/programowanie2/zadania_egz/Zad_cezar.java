package com.example.programowanie2.zadania_egz;

import java.util.Arrays;

public class Zad_cezar {


    public static void main(String[] args) {
        String[] slowa = {"ABA a asdf", "aba"};
        String[] szyfr = cezar(slowa, true);
        System.out.println(Arrays.toString(szyfr));
    }

    private static String[] cezar(String[] tekst, boolean kodek) {
        int kierunek = kodek ? 1 : -1;

        for (int i = 0; i < tekst.length; i++) {
            String slowo = tekst[i];
            StringBuilder sb = new StringBuilder();

            for (char znak : slowo.toCharArray()) {
                sb.append(Character.toString(znak+kierunek));
            }
            tekst[i] = sb.toString();
        }

        return tekst;
    }
}

package com.example.programowanie2.zadania_egz;

/**
 * Zdefiniować klasę opisującą grę w statki o polach:
 *      imię gracza (łańcuch znaków)
 *      nazwisko gracza (łańcuch znaków)
 *      plansza (dwuwymiarowa tablica boolowska)
 * Zdefiniować metody:
 *      konstruktor z parametrami: imię i nazwisko gracza, liczba wierszy i liczba kolumn (tworzy tablicę)
 *
 *      umieszczającą jednomasztowiec (true) na polu o podanych współrzędnych
 *
 *      umieszczającą dwumasztowiec na polach o podanych wspólrzędnych; jeśli współrzędne nie wskazują elementów
 *      w jednym wierszu lub w jednej kolumnie, to metoda zwraca false, inaczej true
 *
 *      wykonującą strzał - parametrami są współrzędne strzału, wynikiem napis: "trafiony" lub "pudło"
 */
public class Zad_klasa_3 {
    public static void main(String[] args) {

    }
}

class GraWStatki {
    private String imie;
    private String nazwisko;
    private boolean[][] plansza;

    GraWStatki(String imie, String nazwisko, int planszaWiersze, int planszaKolumny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plansza = new boolean[planszaWiersze][planszaKolumny];
    }

    boolean umiescJednomasztowiec(int wiersz, int kolumna) {
        boolean poprawnyWiersz = wiersz >= 0 && wiersz < plansza.length;
        boolean poprawnaKolumna = kolumna >= 0 && kolumna < plansza[0].length;
        if (poprawnyWiersz && poprawnaKolumna) {
            plansza[wiersz][kolumna] = true;
            return true;
        }
        return false;
    }

    boolean umiescDwumasztowiec(int w1, int k1, int w2, int k2) {
        boolean wJednejLinii = (w1 == w2 || k1 == k2);
        boolean saSasiadujace = (Math.abs(w1 - w2) + Math.abs(k1 - k2) == 1);
        if (wJednejLinii && saSasiadujace) {
            plansza[w1][k1] = true;
            plansza[w2][k2] = true;
            return true;
        }
        return false;
    }

    String strzal(int wiersz, int kolumna) {
        return plansza[wiersz][kolumna] ? "trafiony" : "pudło";
    }
}

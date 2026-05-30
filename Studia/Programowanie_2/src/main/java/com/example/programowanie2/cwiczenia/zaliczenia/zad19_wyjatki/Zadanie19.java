package com.example.programowanie2.cwiczenia.zaliczenia.zad19_wyjatki;

public class Zadanie19 {
    public static void main(String[] args) {
        Kolejka k = new Kolejka();

        try {
            k.doKolejki(new Integer(7));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new Double(3.14));
            for (int i = 1; i <= 3; ++i) {
                System.out.println((k.zKolejki()).toString());
            }
        } catch (Przepelnienie e) {
            System.out.println("Przepełniona kolejka!");
        } catch (Niedomiar e) {
            System.out.println("Pusta kolejka!");
        }
    }
}

class Kolejka {
    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost, lbel;

    public Kolejka() {
        pocz = 0;
        zaost = 0;
        lbel = 0;
        tab = new Object[N];
    }

    void doKolejki(Object el) {
        if (lbel == N) throw new Przepelnienie("Kolejka zapełniona!");
        tab[zaost] = el;
        zaost = (zaost+1) % N;
        ++lbel;
    }

    Object zKolejki() {
        if (lbel == 0) throw new Niedomiar("Brak elementów w kolejce!");
        int ind = pocz;
        pocz = (pocz+1) % N;
        --lbel;
        return tab[ind];
    }
}

class Przepelnienie extends RuntimeException {
    Przepelnienie(String komunikat) {
        super(komunikat);
    }
}

class Niedomiar extends RuntimeException {
    Niedomiar(String komunikat) {
        super(komunikat);
    }
}

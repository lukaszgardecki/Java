package com.example.programowanie2.cwiczenia.zaliczenia.zad20_wyjatki;

public class Zadanie20 {
    public static void main(String[] args) {
        Wyrazenie wyr = new Wyrazenie("(3*((1+2)-1))");
        System.out.println("" + wyr.oblicz());
    }
}

abstract class Wierzcholek {
    Wierzcholek lewy, prawy;
    public abstract int wartosc();
}

class Stala extends Wierzcholek {
    private int wart;

    public Stala(int x) {
        wart = x;
    }

    @Override
    public int wartosc() {
        return wart;
    }
}

class Dzialanie extends Wierzcholek {
    private char op; // operator +, -, / lub *

    public Dzialanie(char znak) {
        if (znak != '+' && znak != '-' && znak != '*' && znak != '/') {
            throw new BledneWyrazenieException("Nieznany operator: " + znak);
        }
        op = znak;
    }

    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }

    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }
    @Override
    public int wartosc() {
        if (lewy == null || prawy == null) {
            throw new BledneWyrazenieException("Brak argumentu dla operatora " + op);
        }
        switch (op) {
            case '+': return lewy.wartosc() + prawy.wartosc();
            case '-': return lewy.wartosc() - prawy.wartosc();
            case '/':
                int mianownik = prawy.wartosc();
                if (mianownik == 0) {
                    throw new DzieleniePrzezZeroException("Dzielenie przez zero!");
                }
                return lewy.wartosc() / mianownik;
        }
        return 0;
    }
}

class Wyrazenie {
    private Wierzcholek korzen;

    private Wierzcholek utworzDrzewo(String w, int p, int q) {
        if (p > q) throw new BledneWyrazenieException("Puste podwyrażenie. Sprawdź nawiasy.");

        if (p == q) {
            return new Stala(Character.digit(w.charAt(p), 10));
        } else {
            int i = p+1, nawiasy = 0;

            try {
                while ( (nawiasy != 0) || (w.charAt(i) == '(') || (w.charAt(i) == ')') || Character.isDigit(w.charAt(i))) {
                    if (w.charAt(i) == '(') ++nawiasy;
                    if (w.charAt(i) == ')') --nawiasy;
                    ++i;
                }

                if (i >= q) throw new BledneWyrazenieException("Nie odnaleziono właściwego operatora.");

                Dzialanie nowy = new Dzialanie(w.charAt(i));
                nowy.dodajLewyArg(utworzDrzewo(w, p + 1, i - 1));
                nowy.dodajPrawyArg(utworzDrzewo(w, i + 1, q - 1));
                return nowy;
            } catch (IndexOutOfBoundsException e) {
                throw new BledneWyrazenieException("Niezbalansowane nawiasy lub urwane wyrażenie.");
            }
        }
    }

    public Wyrazenie(String w) {
        if (w == null || w.isBlank()) {
            throw new BledneWyrazenieException("Wyrażenie nie może być puste.");
        }
        korzen = utworzDrzewo(w, 0, w.length() - 1);
    }

    public int oblicz() {
        return korzen.wartosc();
    }
}

class DzieleniePrzezZeroException extends RuntimeException {
    DzieleniePrzezZeroException(String komunikat) {
        super(komunikat);
    }
}

class BledneWyrazenieException extends RuntimeException {
    BledneWyrazenieException(String komunikat) {
        super(komunikat);
    }
}
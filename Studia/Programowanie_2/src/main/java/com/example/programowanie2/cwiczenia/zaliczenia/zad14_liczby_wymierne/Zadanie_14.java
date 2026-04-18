package com.example.programowanie2.cwiczenia.zaliczenia.zad14_liczby_wymierne;

class Rational implements Comparable<Rational> {
    private final int licznik;
    private final int mianownik;

    public Rational(int licznik, int mianownik) {
        if (mianownik == 0) throw new IllegalStateException("Mianownik musi być różny od 0!");
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    public Rational add(Rational arg) {
        int l = this.licznik * arg.mianownik + arg.licznik * this.mianownik;
        int m = this.mianownik * arg.mianownik;
        return new Rational(l, m).skroc();
    }

    public Rational mul(Rational arg) {
        int l = this.licznik * arg.licznik;
        int m = this.mianownik * arg.mianownik;
        return new Rational(l, m).skroc();
    }

    public Rational sub(Rational arg) {
        int l = this.licznik * arg.mianownik - arg.licznik * this.mianownik;
        int m = this.mianownik * arg.mianownik;
        return new Rational(l, m).skroc();
    }

    public Rational div(Rational arg) {
        int l = this.licznik * arg.mianownik;
        int m = this.mianownik * arg.licznik;
        return new Rational(l, m).skroc();
    }

    public boolean equals(Rational arg) {
        Rational a = this.skroc();
        Rational b = arg.skroc();
        return a.licznik == b.licznik && a.mianownik == b.mianownik;
    }

    @Override
    public int compareTo(Rational arg) {
        long left = (long) this.licznik * arg.mianownik;
        long right = (long) this.mianownik * arg.licznik;

        if (left == right) return 0;
        else if (left < right) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "%d/%d".formatted(licznik, mianownik);
    }

    private Rational skroc() {
        int nwd = liczNajwiekszyWspolnyDzielnik(licznik, mianownik);
        int skroconyLicznik = licznik / nwd;
        int skroconyMianownik = mianownik / nwd;

        // przeniesienie minusa z mianownika do licznika
        if (skroconyMianownik < 0) {
            skroconyLicznik *= -1;
            skroconyMianownik *= -1;
        }

        return new Rational(skroconyLicznik, skroconyMianownik);
    }

    private static int liczNajwiekszyWspolnyDzielnik(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }
}
package com.example.programowanie2.cwiczenia.zaliczenia.zad22_kolekcje_HashMap;

import java.util.HashMap;

public class Zadanie22 {
    public static void main(String[] args) {
        HashMap mapa = new  HashMap();
        mapa.put(new Wspolrzedna(2, 3), new String("czerwony"));
        mapa.put(new Wspolrzedna(-3, 0), new String("czarny"));
        mapa.put(new Wspolrzedna(-1, 2), new String("czerwony"));
        mapa.put(new Wspolrzedna(2, -1), new String("czarny"));

        Wspolrzedna w = new Wspolrzedna(-1, 2);
        System.out.println("Punkt " + w.toString() + " ma kolor " + mapa.get(w));
    }
}


class Wspolrzedna implements Comparable<Wspolrzedna> {
    private int x, y;

    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Wspolrzedna o) {
        if (this.x != o.x) {
            return (this.x < o.x) ? -1 : 1;
        }
        if (this.y == o.y) return 0;
        return (this.y < o.y) ? -1 : 1;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Wspolrzedna that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

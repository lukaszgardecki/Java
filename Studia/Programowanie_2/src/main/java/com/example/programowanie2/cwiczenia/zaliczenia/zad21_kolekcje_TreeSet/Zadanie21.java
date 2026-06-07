package com.example.programowanie2.cwiczenia.zaliczenia.zad21_kolekcje_TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Zadanie21 {
    private static void wypiszElementu(TreeSet zbior) {
        Iterator it = zbior.iterator();
        while(it.hasNext()) {
            System.out.println((it.next()).toString());
        }
    }

    public static void main(String[] args) {
        TreeSet zbior = new TreeSet();
        zbior.add( new Wspolrzedna(2, 3) );
        zbior.add( new Wspolrzedna(-3, 0) );
        zbior.add( new Wspolrzedna(-1, 2) );
        zbior.add( new Wspolrzedna(-1, 2) );
        zbior.add( new Wspolrzedna(-3, -2) );
        wypiszElementu(zbior);
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
}

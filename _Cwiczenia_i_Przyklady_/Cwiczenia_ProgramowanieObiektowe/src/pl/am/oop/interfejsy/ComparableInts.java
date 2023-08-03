package pl.am.oop.interfejsy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparableInts {
    public static void main(String[] args) {
        ArrayList<Integer> liczby = new ArrayList<>();

        liczby.add(7);
        liczby.add(1);
        liczby.add(35);
        liczby.add(-45);
        liczby.add(8);
        liczby.add(0);

        //sortowanie listy
        Collections.sort(liczby);

        System.out.println(liczby);
    }
}

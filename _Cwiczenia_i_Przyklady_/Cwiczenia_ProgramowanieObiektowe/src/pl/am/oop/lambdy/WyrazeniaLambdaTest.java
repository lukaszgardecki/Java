package pl.am.oop.lambdy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WyrazeniaLambdaTest {
    public static void main(String[] args) {
        ArrayList<Kot> koty = new ArrayList<>();
        koty.add(new Kot("mruczek", 2.5));
        koty.add(new Kot("filemon", 3));
        koty.add(new Kot("bonifacy", 2));
        koty.add(new Kot("w butach", 2.8));
        koty.add(new Kot("mia³", 2.1));
        koty.add(new Kot("kotek", 2.7));

        Collections.sort(koty);

        System.out.println("Sortowanie alfabetyczne po nazwach");
        for (Kot kot : koty) {
            System.out.println(kot);
        }
        //definiowanie wyra¿enia lambda, mozemy ich u¿ywaæ w tych miejscach, w których by³ u¿ywany interfejs z jedn¹ metod¹ abstrakcyjn¹:
        //Comparator<Kot> masaComparator = (kot1, kot2) -> Double.compare(kot1.getMasa(), kot2.getMasa());

        koty.sort((kot1, kot2) -> Double.compare(kot1.getMasa(), kot2.getMasa()));
        System.out.println("Sortowanie po masie");
        for (Kot kot : koty) {
            System.out.println(kot);
        }
    }
}

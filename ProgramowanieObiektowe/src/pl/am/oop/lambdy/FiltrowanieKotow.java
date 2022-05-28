package pl.am.oop.lambdy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class FiltrowanieKotow {
    public static void main(String[] args) {
        ArrayList<Kot> koty = new ArrayList<>();
        koty.add(new Kot("mruczek", 2.5));
        koty.add(new Kot("filemon", 3));
        koty.add(new Kot("bonifacy", 2));
        koty.add(new Kot("w butach", 2.8));
        koty.add(new Kot("mia³", 2.1));
        koty.add(new Kot("kotek", 2.7));

        //lambda:
        koty.sort((kot1, kot2) -> Double.compare(kot1.getMasa(), kot2.getMasa()));
        System.out.println("Sortowanie po masie");
        for (Kot kot : koty) {
            System.out.println(kot);
        }

        System.out.println("Tylko du¿e koty");

        //lambda:
        koty.removeIf(kot -> kot.getMasa() <= 2.5);
        for (Kot kot : koty) {
            System.out.println(kot);
        }
    }
}

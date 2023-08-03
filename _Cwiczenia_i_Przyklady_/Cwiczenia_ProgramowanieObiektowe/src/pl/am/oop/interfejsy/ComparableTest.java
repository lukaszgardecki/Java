package pl.am.oop.interfejsy;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableTest {
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

        Collections.sort(koty, new MasaComparator());
        System.out.println("Sortowanie po masie");
        for (Kot kot : koty) {
            System.out.println(kot);
        }
    }
}

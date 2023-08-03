package pl.am.oop.lambdy;

import java.util.ArrayList;

public class InterfejsyTest {
    public static void main(String[] args) {

        ArrayList<Jajonosnosc> ptaki = new ArrayList<>();

        ptaki.add(new Kura(1.5));
        ptaki.add(new Kura(1.5));
        ptaki.add(new Kura(1.5));
        ptaki.add(new Kaczka(1.8));
        ptaki.add(new Kaczka(1.8));
        ptaki.add(new Kaczka(1.8));

        for (Jajonosnosc ptak : ptaki) {
            ptak.zniesJajo();
        }

        System.out.println();
        ArrayList<Mlekodajnosc> mleczne = new ArrayList<>();

        mleczne.add(new Krowa(230));
        mleczne.add(new Krowa(290));
        mleczne.add(new Koza(110));
        mleczne.add(new Koza(130));
        mleczne.add(new Koza(120));

        for (Mlekodajnosc czworonogmleczny : mleczne) {
            czworonogmleczny.dajMleko();
        }
    }
}

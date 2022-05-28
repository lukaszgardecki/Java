package pl.am.oop.farma2;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) {

        //Utworzenie listy:
        ArrayList<Zwierze> zwierzeta = new ArrayList<>();
        zwierzeta.add(new Pies("Reksio",15));
        zwierzeta.add(new Kot("Kitek", 3));
        zwierzeta.add(new Kura(1));
        zwierzeta.add(new Krowa(200));

        //pêtla wymieniaj¹ca elementy listy:
        for (int i = 0; i < zwierzeta.size(); i++) {
            zwierzeta.get(i).dajGlos();
        }

        //For each. rozszerzona wersja pêtli for. Przechodzi przez wszystkie elementy tablicy.
        for (Zwierze zwierze : zwierzeta) {
            zwierze.dajGlos();
        }


    }
}

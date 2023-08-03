package Kolekcja;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> wyrazy = new ArrayList<String>();


        //dodawanie pozycji do listy, spos�b 2:
        wyrazy.add("To");
        wyrazy.add("jest");
        wyrazy.add("nasza");
        wyrazy.add("wspania�a");
        wyrazy.add("lista");

        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //dodawanie pozycji do listy, spos�b 1:
        wyrazy.add(3, "nie");

        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //usuwanie pozycji z listy:
        wyrazy.remove("nasza");

        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //czy lista zawiera jaki� argument:
        System.out.println(wyrazy.contains("nasza"));

        //podaj pozycj� na li�cie, szuka po ca�ych pozycjach, tzn. �e je�eli lista zawiera WYRAZY to indexOf szuka ca�ych wyraz�w, je�eli lista zawiera pojedyncze litery, to szuka pojedynczych liter. Je�eli lista zawiera ca�e wyrazy, a b�dziemy chcieli zwr�ci� indeks litery to program zwr�ci b��dny wynik.
        System.out.println(wyrazy.indexOf("wspania�a"));

        //b��dny przyk�ad:
        System.out.println("przyk�ad b��dnego wyszukiwania: szukamy literki 'a' na li�cie wyrazy: " + wyrazy.indexOf("a"));

        //ostatnie wystapienie na li�cie:
        System.out.println(wyrazy.lastIndexOf("jest"));

        //pobierz element z listy:
        System.out.println(wyrazy.get(4));

        //zast�p elementy:
        wyrazy.set(4,"karczma");
        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //podaj z ilu element�w sk�ada si� nasza lista:
        System.out.println();
        System.out.println(wyrazy.size());

    }
}

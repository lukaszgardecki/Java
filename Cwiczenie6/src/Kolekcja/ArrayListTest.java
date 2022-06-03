package Kolekcja;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> wyrazy = new ArrayList<String>();


        //dodawanie pozycji do listy, sposób 2:
        wyrazy.add("To");
        wyrazy.add("jest");
        wyrazy.add("nasza");
        wyrazy.add("wspania³a");
        wyrazy.add("lista");

        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //dodawanie pozycji do listy, sposób 1:
        wyrazy.add(3, "nie");

        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //usuwanie pozycji z listy:
        wyrazy.remove("nasza");

        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //czy lista zawiera jakiœ argument:
        System.out.println(wyrazy.contains("nasza"));

        //podaj pozycjê na liœcie, szuka po ca³ych pozycjach, tzn. ¿e je¿eli lista zawiera WYRAZY to indexOf szuka ca³ych wyrazów, je¿eli lista zawiera pojedyncze litery, to szuka pojedynczych liter. Je¿eli lista zawiera ca³e wyrazy, a bêdziemy chcieli zwróciæ indeks litery to program zwróci b³êdny wynik.
        System.out.println(wyrazy.indexOf("wspania³a"));

        //b³êdny przyk³ad:
        System.out.println("przyk³ad b³êdnego wyszukiwania: szukamy literki 'a' na liœcie wyrazy: " + wyrazy.indexOf("a"));

        //ostatnie wystapienie na liœcie:
        System.out.println(wyrazy.lastIndexOf("jest"));

        //pobierz element z listy:
        System.out.println(wyrazy.get(4));

        //zast¹p elementy:
        wyrazy.set(4,"karczma");
        for (String x : wyrazy) {
            System.out.print(x + " ");
        }

        //podaj z ilu elementów sk³ada siê nasza lista:
        System.out.println();
        System.out.println(wyrazy.size());

    }
}

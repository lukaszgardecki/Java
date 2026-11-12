package wzorce.dekorator.Zadanie1;

import wzorce.dekorator.Zadanie1.dekoratory.*;
import wzorce.dekorator.Zadanie1.napoje.Herbata;
import wzorce.dekorator.Zadanie1.napoje.Kawa;
import wzorce.dekorator.Zadanie1.napoje.Napoj;

/**
 * Zadanie 1: System zamówień w kawiarni
 *
 * - zaimplementuj system zamawiania napojów, w którym bazowy napój (np. kawa, herbata) może być dekorowany dodatkami (np. mleko, cukier, syrop, bita śmietana)
 * - Wymagania:
 *      - interfejs Napoj z metodą double koszt() i String opis()
 *      - klasy bazowe: Kawa, Herbata
 *      - dekoratorzy: Mleko, Cukier, Syrop, BitaSmietana
 * - Roszerzenia:
 *      - dodaj dekorator ZnizkaStudencka, który obniża cenę o 10%
 *      - dodaj dekorator EkologiczneOpakowanie, który dolicza opłatę za biodegradowalne opakowanie
 */
public class Zadanie1 {
    public static void main(String[] args) {
        Napoj zamowienie1 = new Cukier(new Mleko(new Kawa()));
        Napoj zamowienie2 = new ZnizkaStudencka(new EkologiczneOpakowanie(new Mleko(new BitaSmietana(new Cukier(new Syrop(new Herbata()))))));



        System.out.println("Opis: " + zamowienie1.opis());
        System.out.println("Koszt: " + zamowienie1.koszt() + " zł");

        System.out.println("Opis: " + zamowienie2.opis());
        System.out.println("Koszt: " + zamowienie2.koszt() + " zł");
    }
}

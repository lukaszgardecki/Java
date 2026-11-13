package wzorce.behawioralne.polecenie.Zadanie5;

import wzorce.behawioralne.polecenie.Zadanie5.polecenia.*;

import java.util.List;

/**
 * Zadanie 4: Gra strategiczna
 *
 * - utwórz polecenia: Atakuj, BronSie, Buduj, ZbierajSurowce
 * - gracz wydaje polecenia jednostkom poprzez obiekt Dowodca
 * - dodaj możliwość zapisywania scenariuszy bitewnych jako makropolecenia
 * - rozszerz o cofanie ruchów (np. anulowanie budowy)
 */
public class Main {

    public static void main(String[] args) {
        Jednostka wojownik = new Jednostka();
        Dowodca dowodca = new  Dowodca();

        Polecenie atak = new Atakuj(wojownik);
        Polecenie obrona = new BronSie(wojownik);
        Polecenie budowa = new Buduj(wojownik);
        Polecenie zbieranie = new ZbierajSurowce(wojownik);

        List<Polecenie> scenariusz = List.of(atak, budowa, zbieranie);
        Polecenie makro = new MakroPolecenie(scenariusz);

        dowodca.wydajRozkaz(atak);
        dowodca.wydajRozkaz(obrona);

        System.out.println();
        dowodca.cofnijOstatniRozkaz();

        System.out.println("\nRozkaz makro:");
        dowodca.wydajRozkaz(makro);

        System.out.println();
        dowodca.cofnijOstatniRozkaz();
    }
}

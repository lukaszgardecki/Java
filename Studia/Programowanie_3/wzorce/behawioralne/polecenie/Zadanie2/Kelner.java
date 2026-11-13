package wzorce.behawioralne.polecenie.Zadanie2;

import wzorce.behawioralne.polecenie.Zadanie2.polecenia.Polecenie;

import java.util.ArrayList;
import java.util.List;

/**
 * Stanowi kolejkę poleceń. Nie jest obowiązkowy.
 */
public class Kelner {
    private final List<Polecenie> kolejka = new ArrayList<>();

    public void przyjmijPolecenie(Polecenie polecenie) {
        kolejka.add(polecenie);
    }

    public void wykonajZamowienia() {
        System.out.println("Kelner przekazuje zamówienia do kuchni:");
        for (Polecenie p : kolejka) {
            p.wykonaj();
        }
        kolejka.clear();
    }
}

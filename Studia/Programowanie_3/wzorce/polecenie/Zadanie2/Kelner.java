package wzorce.polecenie.Zadanie2;

import java.util.ArrayList;
import java.util.List;

public class Kelner {
    private final List<Polecenie> kolejka = new ArrayList<>();

    void przyjmijPolecenie(Polecenie polecenie) {
        kolejka.add(polecenie);
    }

    void wykonajZamowienia() {
        System.out.println("Kelner przekazuje zamówienia do kuchni:");
        for (Polecenie p : kolejka) {
            p.wykonaj();
        }
        kolejka.clear();
    }
}

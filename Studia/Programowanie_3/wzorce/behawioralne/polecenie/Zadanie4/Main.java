package wzorce.behawioralne.polecenie.Zadanie4;

import java.util.List;

/**
 * Zadanie 4: Aplikacja bankowa
 *
 * - utwórz polecenia: Wplata, Wyplata, Przelew
 * - każde poelcenie dziąła na obiekcie KontoBankowe
 * - dodaj historię operacji i możilwość cofnięcia ostatniej transakcji
 * - rozszerz o makropolecenie "Stałe zlecenie" (np. comiesięczny przelew)
 */
public class Main {

    public static void main(String[] args) {
        KontoBankowe konto = new KontoBankowe();
        HistoriaOperacji historia = new HistoriaOperacji();

        Polecenie wplata = new Wplata(konto, 500);
        Polecenie wyplata = new Wyplata(konto, 200);
        Polecenie przelew = new Przelew(konto, 100, "Jan Kowalski");

        List<Polecenie> zestaw = List.of(
                new Wplata(konto, 1000),
                new Przelew(konto, 300, "Sklep ABC"),
                new Wyplata(konto, 150)
        );
        Polecenie makro = new MakroPolecenie(zestaw);

        historia.wykonaj(wplata);
        historia.wykonaj(wyplata);
        historia.wykonaj(przelew);

        System.out.println();
        historia.cofnijOstatnie();

        System.out.println("\nPolecenie makro:");
        historia.wykonaj(makro);

        System.out.println();
        historia.cofnijOstatnie();
    }
}

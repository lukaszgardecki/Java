package wzorce.behawioralne.polecenie.Zadanie3;

import wzorce.behawioralne.polecenie.Zadanie3.polecenia.*;

import java.util.List;

/**
 * Zadanie 3: Sterowanie robotem
 *
 * - Utwórz polecenia: IdzDoPrzodu, ObrocWLewo, ObrocWPrawo, PodniesPrzedmiot
 * - Robot wykonuje polecenia krok po kroku
 * - dodaj możliwość zapisania sekwencji ruchów jako makropolecenia i odtworzenia ich później
 * - rozszerz o cofanie ruchów (np. powrót do poprzedniej pozycji)
 */
public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot();
        SterownikRobota sterownik = new SterownikRobota();

        // Pojedyncze polecenia
        Polecenie ruch1 = new IdzDoPrzodu(robot);
        Polecenie ruch2 = new ObrocWLewo(robot);
        Polecenie ruch3 = new PodniesPrzedmiot(robot);

        // Makropolecenie: sekwencja ruchów
        List<Polecenie> sekwencja = List.of(
                new IdzDoPrzodu(robot),
                new ObrocWPrawo(robot),
                new IdzDoPrzodu(robot),
                new PodniesPrzedmiot(robot)
        );
        Polecenie makro = new MakroPolecenie(sekwencja);

        System.out.println("Wykonywanie pojedynczych poleceń:");
        sterownik.wykonaj(ruch1);
        sterownik.wykonaj(ruch2);
        sterownik.wykonaj(ruch3);

        System.out.println();
        sterownik.cofnijOstatnie();

        System.out.println("\nWykonywanie makropolecenia:");
        sterownik.wykonaj(makro);

        System.out.println();
        sterownik.cofnijOstatnie();
    }
}

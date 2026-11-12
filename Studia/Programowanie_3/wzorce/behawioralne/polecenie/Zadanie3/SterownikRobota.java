package wzorce.behawioralne.polecenie.Zadanie3;

import java.util.Stack;

public class SterownikRobota {
    private final Stack<Polecenie> historia = new Stack<>();

    void wykonaj(Polecenie polecenie) {
        polecenie.wykonaj();
        historia.push(polecenie);
    }

    void cofnijOstatnie() {
        if (!historia.isEmpty()) {
            System.out.println("Cofanie ostatniego polecenia:");
            historia.pop().cofnij();
        } else {
            System.out.println("Brak poleceń do cofnięcia.");
        }
    }
}

package wzorce.behawioralne.polecenie.Zadanie5;

import java.util.Stack;

public class Dowodca {
    private Stack<Polecenie> historia = new  Stack<>();

    void wydajRozkaz(Polecenie polecenie) {
        polecenie.wykonaj();
        historia.push(polecenie);
    }

    void cofnijOstatniRozkaz() {
        if (!historia.isEmpty()) {
            System.out.println("Cofanie ostatniego rozkazu:");
            historia.pop().cofnij();
        } else {
            System.out.println("Brak poleceń do cofnięcia");
        }
    }
}

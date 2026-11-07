package wzorce.polecenie.Zadanie4;

import java.util.Stack;

public class HistoriaOperacji {
    private final Stack<Polecenie> historia = new Stack<>();

    public void wykonaj(Polecenie polecenie) {
        polecenie.wykonaj();
        historia.push(polecenie);
    }

    public void cofnijOstatnie() {
        if (!historia.isEmpty()) {
            System.out.println("Cofanie ostatniej operacji:");
            historia.pop().cofnij();
        } else {
            System.out.println("Brak poleceń do cofnięcia");
        }
    }
}

package wzorce.behawioralne.obserwator.Zadanie5.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.List;

public class RejestrZdarzen implements Podmiot {
    private final List<Obserwator> obserwatorzy = new ArrayList<>();

    public void dodajLog(String wiadomosc) {
        System.out.println("Nowy log: " + wiadomosc);
        powiadomObserwatorow(wiadomosc);
    }

    @Override
    public void dodajObserwatora(Obserwator obserwator) {
        obserwatorzy.add(obserwator);
    }

    @Override
    public void usunObserwatora(Obserwator obserwator) {
        obserwatorzy.remove(obserwator);
    }

    @Override
    public void powiadomObserwatorow(String wiadomosc) {
        obserwatorzy.forEach(obs -> obs.przetworzLog(wiadomosc));
    }
}

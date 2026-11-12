package wzorce.behawioralne.obserwator.Zadanie2.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie2.obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.List;

public class KanalWideo implements Podmiot {
    private final List<Obserwator> obserwatorzy = new ArrayList<>();

    public void dodajFilm(String tytul) {
        System.out.println("Dodano film: " + tytul);
        powiadomObserwatorow(tytul);
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
    public void powiadomObserwatorow(String tytul) {
        obserwatorzy.forEach(obs -> obs.powiadomONowymFilmie(tytul));
    }
}

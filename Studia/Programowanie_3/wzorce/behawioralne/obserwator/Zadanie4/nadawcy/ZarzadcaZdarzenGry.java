package wzorce.behawioralne.obserwator.Zadanie4.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie4.obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.List;

public class ZarzadcaZdarzenGry implements Podmiot {
    private final List<Obserwator> obserwatorzy = new ArrayList<>();

    public void wystapiloZdarzenie(String zdarzenie) {
        System.out.println("Zdarzenie: " + zdarzenie);
        powiadomObserwatorow(zdarzenie);
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
    public void powiadomObserwatorow(String zdarzenie) {
        obserwatorzy.forEach(obs -> obs.reagujNaZdarzenie(zdarzenie));
    }
}

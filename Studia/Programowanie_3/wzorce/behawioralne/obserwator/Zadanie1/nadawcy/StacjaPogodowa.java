package wzorce.behawioralne.obserwator.Zadanie1.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie1.obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.List;

public class StacjaPogodowa implements Podmiot {
    private final List<Obserwator> obserwatorzy = new ArrayList<>();
    private float temperatura;

    public void ustawTemperatura(float temperatura) {
        this.temperatura = temperatura;
        powiadomObserwatorow();
    }

    @Override
    public void dodajObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    @Override
    public void usunObserwatora(Obserwator o) {
        obserwatorzy.remove(o);
    }

    @Override
    public void powiadomObserwatorow() {
        obserwatorzy.forEach(obs -> obs.aktualizuj(temperatura));
    }
}

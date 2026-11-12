package wzorce.behawioralne.obserwator.Zadanie3.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.List;

public class DostawcaKursowWalut implements Podmiot {
    private final List<Obserwator> obserwatorzy = new ArrayList<>();
    private float kurs;

    public void ustawKurs(float kurs) {
        this.kurs = kurs;
        powiadomObserwatorow();
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
    public void powiadomObserwatorow() {
        obserwatorzy.forEach(obs -> obs.aktualizujKurs(kurs));
    }
}

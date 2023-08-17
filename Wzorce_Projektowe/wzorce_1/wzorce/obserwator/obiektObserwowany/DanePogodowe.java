package wzorce.obserwator.obiektObserwowany;

import wzorce.obserwator.obserwatorzy.Obserwator;

import java.util.ArrayList;
import java.util.List;

public class DanePogodowe implements Podmiot {
    private List<Obserwator> obserwatorzy;
    private float wilgotność;
    private float temperatura;
    private float ciśnienie;

    public DanePogodowe() {
        obserwatorzy = new ArrayList<>();
    }

    @Override
    public void zarejestrujObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    @Override
    public void usuńObserwatora(Obserwator o) {
        obserwatorzy.remove(o);
    }

    @Override
    public void powiadomObserwatorów() {
        for (int i = 0; i < obserwatorzy.size(); i++) {
            Obserwator obserwator = obserwatorzy.get(i);
            obserwator.aktualizacja(temperatura, wilgotność, ciśnienie);
        }
    }

    public void odczytyZmiana() {
        powiadomObserwatorów();
    }

    public void ustawOdczyty(float temperatura, float wilgotność, float ciśnienie) {
        this.temperatura = temperatura;
        this.wilgotność = wilgotność;
        this.ciśnienie = ciśnienie;
        odczytyZmiana();
    }
}

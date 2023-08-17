package wzorce.wzorceZłożone;

import java.util.ArrayList;
import java.util.List;

public class Obserwowany implements KwakObserwowany {
    private List<Obserwator> obserwatorzy = new ArrayList<>();
    private KwakObserwowany kaczka;

    public Obserwowany(KwakObserwowany kaczka) {
        this.kaczka = kaczka;
    }

    @Override
    public void zarejestrujObserwatora(Obserwator obserwator) {
        obserwatorzy.add(obserwator);
    }

    @Override
    public void powiadomObserwatorów() {
        for (Obserwator obserwator : obserwatorzy) {
            obserwator.aktualizuj(kaczka);
        }
    }
}

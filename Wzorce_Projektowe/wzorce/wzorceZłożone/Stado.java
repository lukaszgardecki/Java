package wzorce.wzorceZłożone;

import java.util.ArrayList;
import java.util.List;

public class Stado implements Kwacząca{
    private List<Kwacząca> ptaki = new ArrayList<>();

    public void dodaj(Kwacząca ptak) {
        ptaki.add(ptak);
    }

    @Override
    public void kwacz() {
        for (Kwacząca ptak : ptaki) {
            ptak.kwacz();
        }
    }

    @Override
    public void zarejestrujObserwatora(Obserwator obserwator) {
        for (Kwacząca ptak : ptaki) {
            ptak.zarejestrujObserwatora(obserwator);
        }
    }

    @Override
    public void powiadomObserwatorów() {}
}

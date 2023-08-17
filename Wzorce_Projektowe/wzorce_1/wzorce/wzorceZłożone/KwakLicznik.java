package wzorce.wzorceZłożone;

public class KwakLicznik implements Kwacząca {
    private Kwacząca kaczka;
    private static int liczbaKwaknięć;

    public KwakLicznik(Kwacząca kaczka) {
        this.kaczka = kaczka;
    }

    @Override
    public void kwacz() {
        kaczka.kwacz();
        liczbaKwaknięć++;
    }

    public static int pobierzLiczbęKwaknięć() {
        return liczbaKwaknięć;
    }

    @Override
    public void zarejestrujObserwatora(Obserwator obserwator) {
        kaczka.zarejestrujObserwatora(obserwator);
    }

    @Override
    public void powiadomObserwatorów() {
        kaczka.powiadomObserwatorów();
    }
}

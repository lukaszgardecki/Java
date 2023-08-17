package wzorce.wzorceZłożone;

public class GęśAdapter implements Kwacząca {
    private Gęś gęś;
    private Obserwowany obserwowany;

    public GęśAdapter(Gęś gęś) {
        this.gęś = gęś;
        obserwowany = new Obserwowany(this);
    }

    @Override
    public void kwacz() {
        gęś.gęgaj();
    }

    @Override
    public void zarejestrujObserwatora(Obserwator obserwator) {
        obserwowany.zarejestrujObserwatora(obserwator);
    }

    @Override
    public void powiadomObserwatorów() {
        obserwowany.powiadomObserwatorów();
    }
}

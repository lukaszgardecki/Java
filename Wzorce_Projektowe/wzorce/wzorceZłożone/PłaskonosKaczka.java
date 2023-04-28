package wzorce.wzorceZłożone;

public class PłaskonosKaczka implements Kwacząca {
    private Obserwowany obserwowany;

    public PłaskonosKaczka() {
        obserwowany = new Obserwowany(this);
    }

    @Override
    public void kwacz() {
        System.out.println("Kwa! Kwa!");
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

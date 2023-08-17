package wzorce.wzorceZłożone;

public class GumowaKaczka implements Kwacząca{
    private Obserwowany obserwowany;

    public GumowaKaczka() {
        obserwowany = new Obserwowany(this);
    }

    @Override
    public void kwacz() {
        System.out.println("Piszczę!");
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

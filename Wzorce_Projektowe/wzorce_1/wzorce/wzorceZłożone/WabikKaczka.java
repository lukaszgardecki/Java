package wzorce.wzorceZłożone;

public class WabikKaczka implements Kwacząca{
    private Obserwowany obserwowany;

    public WabikKaczka() {
        obserwowany = new Obserwowany(this);
    }

    @Override
    public void kwacz() {
        System.out.println("Kwak");
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

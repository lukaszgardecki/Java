package wzorce.dekorator.wprowadzenie;

abstract class BazowyDekoratorNotyfikatora implements INotyfikator {
    protected INotyfikator opakowanyNotyfikator;

    BazowyDekoratorNotyfikatora(INotyfikator notyfikator) {
        this.opakowanyNotyfikator = notyfikator;
    }

    @Override
    public void wyslij(String wiadomosc) {
        opakowanyNotyfikator.wyslij(wiadomosc);
    }
}

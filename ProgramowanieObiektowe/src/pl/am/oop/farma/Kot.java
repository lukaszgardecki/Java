package pl.am.oop.farma;

public class Kot extends ZwierzeDomowe {

    public Kot(String nazwa, double masa) {
        super(nazwa, masa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Mia³ mia³");
    }
}

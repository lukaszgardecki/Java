package pl.am.oop.zadanie2;

public class Kot extends ZwierzeDomowe {

    public Kot(String nazwa, double masa) {
        super(nazwa, masa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Mia³ mia³");
    }
}

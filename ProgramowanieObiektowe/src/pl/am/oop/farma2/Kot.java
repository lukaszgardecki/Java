package pl.am.oop.farma2;

public class Kot extends ZwierzeDomowe {

    public Kot(String nazwa, double masa) {
        super(nazwa, masa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Mia³ mia³");
    }

    @Override
    public String toString() {
        return "Kot{" +
                "nazwa='" + nazwa + '\'' +
                ", masa=" + masa +
                '}';
    }
}

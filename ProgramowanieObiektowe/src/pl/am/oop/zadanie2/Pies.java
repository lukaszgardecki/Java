package pl.am.oop.zadanie2;

public class Pies extends ZwierzeDomowe {

    public Pies(String nazwa, double masa) {
        super(nazwa, masa);
    }

    public void podajLape() {
        System.out.println("Masz ��p�!");
    }

    @Override
    public void dajGlos() {
        System.out.println("ha� ha�");
    }
}

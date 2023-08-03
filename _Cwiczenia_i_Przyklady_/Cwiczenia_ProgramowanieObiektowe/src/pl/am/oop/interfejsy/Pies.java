package pl.am.oop.interfejsy;

public class Pies extends ZwierzeDomowe {
    private Rasa rasa;

    public Pies(String nazwa, Rasa rasa, double masa) {
        super(nazwa, masa);
        this.rasa = rasa;
    }

    public void podajLape() {
        System.out.println("Masz ��p�!");
    }

    @Override
    public void dajGlos() {
        System.out.println("ha� ha�");
    }

    @Override
    public String toString() {
        return "Pies{" +
                "rasa='" + rasa + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", masa=" + masa +
                '}';
    }
}

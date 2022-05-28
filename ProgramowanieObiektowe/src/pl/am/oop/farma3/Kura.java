package pl.am.oop.farma3;

public class Kura extends ZwierzeHodowlane {

    public Kura(double masa) {
        super(masa);
    }

    public void zniesJajo() {
        System.out.println("Jajko zniesione!");
    }

    @Override
    public void dajGlos() {
        System.out.println("ko ko ko ko ko");
    }

    @Override
    public String toString() {
        return "Kura{" +
                "masa=" + masa +
                '}';
    }
}

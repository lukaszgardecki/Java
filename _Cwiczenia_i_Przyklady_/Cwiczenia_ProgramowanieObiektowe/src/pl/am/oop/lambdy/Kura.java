package pl.am.oop.lambdy;

public class Kura extends ZwierzeHodowlane implements Jajonosnosc {

    public Kura(double masa) {
        super(masa);
    }

    @Override
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

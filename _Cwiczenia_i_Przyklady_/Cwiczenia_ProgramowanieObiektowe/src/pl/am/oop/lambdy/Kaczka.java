package pl.am.oop.lambdy;

public class Kaczka extends ZwierzeHodowlane implements Jajonosnosc {

    public Kaczka(double masa) {
        super(masa);
    }

    @Override
    public void zniesJajo() {
        System.out.println("Kacze jajo zosta³o zniesione");
    }

    @Override
    public void dajGlos() {
        System.out.println("kwa kwa kwa");
    }

    @Override
    public String toString() {
        return "Kaczka{" +
                "masa=" + masa +
                '}';
    }
}

package pl.am.oop.farma2;

public class Krowa extends ZwierzeHodowlane {
    private static int nextId = 1;
    private int id;

    public Krowa(double masa) {
        super(masa);
        id = nextId;
        nextId++;
    }

    public double dajMleko() {
        System.out.println("Dojenie krowy trwa...");
        return masa*0.01;
    }

    @Override
    public void dajGlos() {
        System.out.println("Muuuuuuuuuu");
    }
}

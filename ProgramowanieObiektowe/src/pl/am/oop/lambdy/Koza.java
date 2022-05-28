package pl.am.oop.lambdy;

public class Koza extends ZwierzeHodowlane implements Mlekodajnosc {
    private static int nextId = 1;
    private int id;

    public Koza(double masa) {
        super(masa);
        id = nextId;
        nextId++;
    }
    @Override
    public double dajMleko() {
        System.out.println("Dojenie kozy trwa...");
        return masa*0.01;
    }

    @Override
    public void dajGlos() {
        System.out.println("Muuuuuuuuuu");
    }

    @Override
    public String toString() {
        return "Krowa{" +
                "id=" + id +
                ", masa=" + masa +
                '}';
    }
}

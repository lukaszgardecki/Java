package Zad_35_OwoceWsklepie;

public class Fruit {
    private int weight;
    private String type;

    public Fruit(int weight, String type) {
        this.weight = weight;
        this.type = type;
        getInfo();
    }

    String getInfo() {
         return String.format(getClass().getSimpleName() + ": Waga: %sg, typ: %s", weight, type);
    }


}

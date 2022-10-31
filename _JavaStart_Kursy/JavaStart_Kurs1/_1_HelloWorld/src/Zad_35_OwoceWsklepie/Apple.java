package Zad_35_OwoceWsklepie;

public class Apple extends Fruit{
    private String variety;

    public Apple(int weight, String variety) {
        super(weight, "jab³kowaty");
        this.variety = variety;
    }

    @Override
    String getInfo() {
        return super.getInfo() + ", odmiana: " + variety;
    }
}

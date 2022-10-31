package Zad_35_OwoceWsklepie;

class Apple extends Fruit{
    private String variety;

    public Apple(int weight, String variety) {
        super(weight, "jabłkowaty");
        this.variety = variety;
    }

    @Override
    String getInfo() {
        return super.getInfo() + ", odmiana: " + variety;
    }
}

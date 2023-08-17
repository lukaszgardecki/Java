package wzorce.decorator;

public class CheeseBurstDecorator extends PizzaDecorator {

    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }

    public String bake() {
        return pizza.bake() + addCheese();
    }

    private String addCheese() {
        return " cheese";
    }
}

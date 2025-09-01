import java.util.ArrayList;

public class PizzaWithExtraCheese implements Pizza {
    private final ArrayList<String> toppings;
    private final Pizza pizzaWithExtraCheese;

    public PizzaWithExtraCheese(Pizza pizza) {
        this.pizzaWithExtraCheese = pizza;
        this.toppings = pizza.getToppings();
        toppings.add("extra cheese");
    }

    @Override
    public ArrayList<String> getToppings() {
        return toppings;
    }

    @Override
    public String getName() {
        return pizzaWithExtraCheese.getName();
    }
}

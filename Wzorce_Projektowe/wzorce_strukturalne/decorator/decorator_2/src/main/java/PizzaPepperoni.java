import java.util.ArrayList;

public class PizzaPepperoni implements Pizza {
    private final ArrayList<String> toppings = new ArrayList<>();
    private final String name = "Pepperoni";

    public PizzaPepperoni() {
      toppings.add("cheese");
      toppings.add("tomato");
      toppings.add("pepperoni");
    }

    public ArrayList<String> getToppings() {
      return toppings;
    }

    public String getName() {
      return name;
    }
}

import java.util.ArrayList;

public class PizzaHawaiian implements Pizza {
    private final ArrayList<String> toppings = new ArrayList<>();
    private final String name = "Hawaiiian";

    public PizzaHawaiian() {
      toppings.add("cheese");
      toppings.add("tomato");
      toppings.add("ham");
      toppings.add("pineapple");
    }

    public ArrayList<String> getToppings() {
      return toppings;
    }

    public String getName() {
      return name;
    }
}

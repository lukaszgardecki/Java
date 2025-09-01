import java.util.ArrayList;

public class PizzaMargherita implements Pizza {
    private final ArrayList<String> toppings = new ArrayList<>();
    private final String name = "Margherita";

    public PizzaMargherita() {
      toppings.add("cheese");
      toppings.add("tomato");
    }

    public ArrayList<String> getToppings() {
      return toppings;
    }

    public String getName() {
      return name;
    }
}

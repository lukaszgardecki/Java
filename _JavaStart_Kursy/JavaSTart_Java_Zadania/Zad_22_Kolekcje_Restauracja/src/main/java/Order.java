import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> orders = new ArrayList<>();

    public void add(Dish dish) {
        orders.add(dish);
    }

    public double getPrice() {
        return orders.stream().mapToDouble(Dish::getPrice).sum();
    }
}

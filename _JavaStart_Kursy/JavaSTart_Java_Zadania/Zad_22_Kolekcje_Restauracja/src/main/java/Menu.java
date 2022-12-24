import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> menu = new ArrayList<>();

    public Menu() {
        menu.add(new Dish(1, "Pizza Margheritta", 24.99));
        menu.add(new Dish(2, "Pizza Mafioso", 29.99));
        menu.add(new Dish(3, "Spaghetti Bolognese", 31.99));
        menu.add(new Dish(4, "Spaghetti Carbonara", 26.99));
        menu.add(new Dish(5, "Lasagne", 24.99));
        menu.add(new Dish(6, "Gazpacho", 16.99));
        menu.add(new Dish(7, "Connelloni ze szpinakiem", 29.99));
        menu.add(new Dish(8, "Bruschetta", 13.99));
        menu.add(new Dish(9, "Tiramisu", 19.99));
        menu.add(new Dish(10, "Panna Cotta", 19.99));
    }

    public boolean isDishExists(int id) {
        for (Dish dish : menu) {
            if (dish.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Dish getDish(int id) {
        return menu.get(id - 1);
    }

    public List<Dish> getMenu() {
        return menu;
    }
}

import java.util.List;

public class Barman {

    static Drink createDrink(List<Ingredient> ingredients) {
        return new Drink(ingredients);
    }

    static void printDrink(Drink drink) {
        System.out.println(drink);
    }
}

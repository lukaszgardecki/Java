public class Barman {

    Drink createDrink(String ingredient1Name, int ingredient1Amount,
                      String ingredient2Name, int ingredient2Amount,
                      String ingredient3Name, int ingredient3Amount) {

        return new Drink(
                new Ingredient(ingredient1Name, ingredient1Amount),
                new Ingredient(ingredient2Name, ingredient2Amount),
                new Ingredient(ingredient3Name, ingredient3Amount)
        );
    }

    void printDrink(Drink drink) {
        System.out.println(drink);
    }
}

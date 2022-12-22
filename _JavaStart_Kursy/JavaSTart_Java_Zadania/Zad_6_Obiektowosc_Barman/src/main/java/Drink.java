public class Drink {
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final Ingredient ingredient3;
    private final int volume;

    public Drink(Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.volume = ingredient1.getAmount() + ingredient2.getAmount() + ingredient3.getAmount();
    }

    @Override
    public String toString() {
        return String.format("Składniki drinka to: %s, %s, %s w proporcjach %.2f, %.2f, %.2f. Jego pojemność to %sml.",
                ingredient1.getName(),
                ingredient2.getName(),
                ingredient3.getName(),
                getIngredientProportion(ingredient1),
                getIngredientProportion(ingredient2),
                getIngredientProportion(ingredient3),
                volume
        );
    }

    private double getIngredientProportion(Ingredient ingredient) {
         return (double) ingredient.getAmount() / volume;
    }
}

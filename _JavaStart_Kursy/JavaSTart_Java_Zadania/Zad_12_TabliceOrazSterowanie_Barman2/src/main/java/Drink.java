import java.util.List;
import java.util.stream.Collectors;

public class Drink {
    private List<Ingredient> ingredients;

    public Drink(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return String.format("Drink składa się z %d składników:\n%s",
                ingredients.size(),
                ingredients.stream()
                        .map(Ingredient::toString)
                        .collect(Collectors.joining())
        );

    }
}

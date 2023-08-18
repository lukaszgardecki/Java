package machine.drinks;

import machine.components.Component;
import machine.exception.ComponentNotFoundException;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Coffe {
    protected String name;
    protected Set<Component> ingredients = new LinkedHashSet<>();
    protected int price;

    public String getName() {
        return name;
    }

    public Set<Component> getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    public Component getComponent(Class<?> clazzz) {
        return ingredients.stream()
                .filter(el -> el.getClass().equals(clazzz))
                .findFirst()
                .orElseThrow(ComponentNotFoundException::new);
    }
}

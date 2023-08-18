package machine.drinks;

import machine.components.Beans;
import machine.components.Cups;
import machine.components.Milk;
import machine.components.Water;

public class Latte extends Coffe {

    public Latte() {
        name = "Latte";
        ingredients.add(new Water(350));
        ingredients.add(new Milk(75));
        ingredients.add(new Beans(20));
        ingredients.add(new Cups(1));
        price = 7;
    }
}

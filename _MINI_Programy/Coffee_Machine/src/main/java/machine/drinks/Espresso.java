package machine.drinks;

import machine.components.Beans;
import machine.components.Cups;
import machine.components.Water;

public class Espresso extends Coffe {

    public Espresso() {
        name = "Espresso";
        ingredients.add(new Water(25));
        ingredients.add(new Beans(16));
        ingredients.add(new Cups(1));
        price = 4;
    }
}

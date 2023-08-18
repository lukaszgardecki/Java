package machine.drinks;

import machine.components.Beans;
import machine.components.Cups;
import machine.components.Milk;
import machine.components.Water;

public class Cappuccino extends Coffe {

    public Cappuccino() {
        name = "Cappuccino";
        ingredients.add(new Water(200));
        ingredients.add(new Milk(100));
        ingredients.add(new Beans(12));
        ingredients.add(new Cups(1));
        price = 6;
    }
}

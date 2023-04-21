package wzorce.fabryka.pizzeria;

import wzorce.fabryka.fabryki.FabrykaSkładnikówPizzy;
import wzorce.fabryka.pizza.*;
import wzorce.fabryka.fabryki.WłoskaFabrykaSkładnikówPizzy;

public class WłoskaPizzeria extends Pizzeria {

    public Pizza utwórzPizza(String item) {
        Pizza pizza = null;
        FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy = new WłoskaFabrykaSkładnikówPizzy();

        if (item.equals("serowa")) {
            pizza = new SerowaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Włoska Pizza Serowa");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Włoska Pizza Pepperoni");
        } else if (item.equals("owocemorza")) {
            pizza = new OwoceMorzaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Włoska Pizza Owoce Morza");
        } else if (item.equals("wegetariańska")) {
            pizza = new WegetariańskaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Włoska Pizza Wegetariańska");
        }
        return pizza;
    }

}

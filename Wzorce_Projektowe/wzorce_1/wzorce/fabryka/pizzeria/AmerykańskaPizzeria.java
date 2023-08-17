package wzorce.fabryka.pizzeria;

import wzorce.fabryka.fabryki.FabrykaSkładnikówPizzy;
import wzorce.fabryka.pizza.*;
import wzorce.fabryka.fabryki.AmerykańskaFabrykaSkładnikówPizzy;

public class AmerykańskaPizzeria extends Pizzeria {

    protected Pizza utwórzPizza(String item) {
        Pizza pizza = null;
        FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy = new AmerykańskaFabrykaSkładnikówPizzy();

        if (item.equals("serowa")) {
            pizza = new SerowaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Amerykańska Pizza Serowa");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Amerykańska Pizza Pepperoni");
        } else if (item.equals("owocemorza")) {
            pizza = new OwoceMorzaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Amerykańska Pizza Owoce Morza");
        } else if (item.equals("wegetariańska")) {
            pizza = new WegetariańskaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Amerykańska Pizza Wegetariańska");
        }
        return pizza;
    }

}

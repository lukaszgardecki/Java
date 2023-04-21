package wzorce.fabryka.pizzeria;

import wzorce.fabryka.fabryki.FabrykaSkładnikówPizzy;
import wzorce.fabryka.fabryki.MaksykańskaFabrykaSkładnikówPizzy;
import wzorce.fabryka.pizza.*;

public class MeksykańskaPizzeria extends Pizzeria {

    protected Pizza utwórzPizza(String item) {
        Pizza pizza = null;
        FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy = new MaksykańskaFabrykaSkładnikówPizzy();

        if (item.equals("serowa")) {
            pizza = new SerowaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Meksykańska Pizza Serowa");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Meksykańska Pizza Pepperoni");
        } else if (item.equals("owocemorza")) {
            pizza = new OwoceMorzaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Meksykańska Pizza Owoce Morza");
        } else if (item.equals("wegetariańska")) {
            pizza = new WegetariańskaPizza(fabrykaSkładnikówPizzy);
            pizza.ustawNazwa("Meksykańska Pizza Wegetariańska");
        }
        return pizza;
    }

}

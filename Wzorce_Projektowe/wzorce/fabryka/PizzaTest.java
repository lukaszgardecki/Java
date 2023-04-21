package wzorce.fabryka;

import wzorce.fabryka.pizza.Pizza;
import wzorce.fabryka.pizzeria.AmerykańskaPizzeria;
import wzorce.fabryka.pizzeria.Pizzeria;
import wzorce.fabryka.pizzeria.WłoskaPizzeria;

public class PizzaTest {
    public static void main(String[] args) {

        Pizzeria włoskaPizzeria = new WłoskaPizzeria();
        Pizza pizza = włoskaPizzeria.zamówPizza("serowa");
        System.out.println("Eryk zamówił: " + pizza.pobierzNazwa() + "\n");

        Pizzeria amerykańskaPizzeria = new AmerykańskaPizzeria();
        pizza = amerykańskaPizzeria.zamówPizza("serowa");
        System.out.println("Jacek zamówił: " + pizza.pobierzNazwa() + "\n");

    }
}

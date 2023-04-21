package wzorce.fabryka.pizzeria;

import wzorce.fabryka.pizza.Pizza;

public abstract class Pizzeria {
    /*
    Pizzeria została zaimplementowana jako METODA FABRYKUJĄCA,
    ponieważ zapewnia interfejs abstrakcyjny umożliwiający tworzenie JEDNEGO PRODUKTU.

    Każda klasa podrzędna decyduje o tym, obiekt której klasy rzeczywistej zostanie utworzony.
    */

    public Pizza zamówPizza(String type) {
        Pizza pizza;
        pizza = utwórzPizza(type);
        pizza.przygotowanie();
        pizza.pieczenie();
        pizza.krojenie();
        pizza.pakowanie();
        return pizza;
    }

    protected abstract Pizza utwórzPizza(String type);
}

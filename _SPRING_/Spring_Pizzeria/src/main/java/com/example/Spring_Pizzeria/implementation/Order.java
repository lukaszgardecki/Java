package com.example.Spring_Pizzeria.implementation;

import com.example.Spring_Pizzeria.api.IOrder;
import com.example.Spring_Pizzeria.api.IPizza;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order implements IOrder {
    private IPizza pizza;

    public Order(@Value("#{goodPizza}") IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void printOrder() {
        System.out.println("Zamówienie: " + pizza.getName() + " cena: " + pizza.getPrice());
    }
}

package com.example.Spring_Pizzeria.implementation;

import com.example.Spring_Pizzeria.api.GoodPizza;
import com.example.Spring_Pizzeria.api.IPizza;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@GoodPizza
public class ExoticPizza implements IPizza {
    private int price;
    private String name;
    @Value("#{goodPizza.price matches '[\\d][\\d]'}")
    boolean bool;

    public ExoticPizza(
            @Value("#{goodPizza.price > 13 ? 13 : 20}") int price,
            @Value("#{goodPizza.getName()?.toUpperCase()}") String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        System.out.println(bool);
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}

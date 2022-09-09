package com.example.Spring_Pizzeria.implementation;

import com.example.Spring_Pizzeria.api.GoodPizza;
import com.example.Spring_Pizzeria.api.IOrder;
import com.example.Spring_Pizzeria.api.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class ExclusiveOrder implements IOrder {

//          WSTRZYKIWANIE ZALEŻNOŚCI PRZEZ REFLEKSJĘ
//    @Autowired
//    @GoodPizza
    @Value("#{listOfPizza[1]}")
    private IPizza pizza;

    @Autowired
    private List<IPizza> listOfPizza;

    public ExclusiveOrder() {
        super();
    }


    //          WSTRZYKIWANIE ZALEŻNOŚCI PRZEZ SETTER
    //@Value("#{exoticPizza}")
    public void setPizza(IPizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public void printOrder() {
        System.out.println("Zamówienie exclusive: " + pizza.getName() + " cena: " + pizza.getPrice());
    }
}

package com.example.Spring_Pizzeria.config;

import com.example.Spring_Pizzeria.api.IOrder;
import com.example.Spring_Pizzeria.api.IPizza;
import com.example.Spring_Pizzeria.implementation.ExoticPizza;
import com.example.Spring_Pizzeria.implementation.GoodPizza;
import com.example.Spring_Pizzeria.implementation.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Konfiguracja jawna

@Configuration
public class Config {
    @Bean
    public IPizza pizza() {
        return new ExoticPizza(17, "Exotic");
    }

//    @Bean("inna")
//    public IOrder order(IPizza pizza) {
//        return new Order(pizza);
//    }
}

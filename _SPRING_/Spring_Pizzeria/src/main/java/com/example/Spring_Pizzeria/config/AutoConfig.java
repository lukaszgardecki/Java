package com.example.Spring_Pizzeria.config;

import com.example.Spring_Pizzeria.api.IPizza;
import com.example.Spring_Pizzeria.implementation.ExoticPizza;
import com.example.Spring_Pizzeria.implementation.GoodPizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.example.Spring_Pizzeria.implementation")
@Import(Config.class)
public class AutoConfig {

    @Bean
    public List<IPizza> listOfPizza() {
        List<IPizza> listOfPizza = new ArrayList<IPizza>();
        listOfPizza.add(new ExoticPizza(15, "exotic"));
        listOfPizza.add(new GoodPizza(10, "good"));
        return listOfPizza;
    }

}

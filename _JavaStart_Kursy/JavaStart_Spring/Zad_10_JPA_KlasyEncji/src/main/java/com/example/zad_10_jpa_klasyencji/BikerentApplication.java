package com.example.zad_10_jpa_klasyencji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        NewBikeDto bike1 = new NewBikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeService bikeService = context.getBean(BikeService.class);

        //Dodajemy rower do bazy:
        bikeService.add(bike1);


        //Wypożyczamy rower:
        double payment = bikeService.rentForHours(1L, 5, "ABC999");

        System.out.println("Należność do zapłaty za wypożyczenie: " + payment);

        //Zwracamy rower:
        bikeService.returnBike(1L);
    }

}

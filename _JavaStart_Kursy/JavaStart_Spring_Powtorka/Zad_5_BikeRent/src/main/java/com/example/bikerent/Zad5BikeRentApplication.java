package com.example.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zad5BikeRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad5BikeRentApplication.class, args);
        BikeService service = context.getBean(BikeService.class);

        BikeDto bike1 = new BikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeDto bike2 = new BikeDto(2L, "Merida Kalahari 2020, 29 damski", "MK2020X9876", 25, 80);
        BikeDto bike3 = new BikeDto(3L, "Trek XSpeed 2, 29 cali męski", "TXS229M1234", 30, 120);
        BikeDto bike4 = new BikeDto(4L, "Superior XR Super, 26 cali damski", "SXRS26ASDF", 40, 150);
        service.add(bike1);
        service.add(bike2);
        service.add(bike3);
        service.add(bike4);

        double payment = service.rentForDay("TXS229M1234", "ABC1234");
        System.out.println("Wypożyczono rower za kwotę: " + payment);

        int borrowedBikes = service.countBorrowedBikes();
        System.out.println("Liczba wypożyczonych rowerów: " + borrowedBikes);

        System.out.println("Dostępne rowery (cena rosnąco):");
        service.findAllAvailableBikes().forEach(System.out::println);
    }

}

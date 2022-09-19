package com.example.Spring_Boot_Przyklad.repository;

import com.example.Spring_Boot_Przyklad.model.Pizza;
import org.springframework.data.repository.CrudRepository;

/*
        Repozytorium jest nam potrzebne do przechowywania danych w bazie
 */

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

}

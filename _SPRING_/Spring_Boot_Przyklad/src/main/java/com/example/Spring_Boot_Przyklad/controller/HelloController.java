package com.example.Spring_Boot_Przyklad.controller;

import com.example.Spring_Boot_Przyklad.model.Pizza;
import com.example.Spring_Boot_Przyklad.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Controller
public class HelloController {

    // musimy wstrzyknąć nasze repozytorium, żeby kontroler mógł go używać
    @Autowired
    private PizzaRepository pizzaRepository;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "home";
    }

    @GetMapping("/allPizzas")
    public String allPizzas(Model model) {
        List<Pizza> allPizzas = (List<Pizza>) pizzaRepository.findAll();
        model.addAttribute("allPizzas", allPizzas);
        return "pizzas";
    }

    @PostMapping("/pizza")
    public String pizza(@ModelAttribute Pizza pizza) {
        pizzaRepository.save(pizza);
        return "pizza";
    }




}

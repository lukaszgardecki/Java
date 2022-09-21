package com.example.Spring_MVC_Cwiczenie;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "world" )
            String name,
            Model model) {

        /**
         * "name" z addAttribute TO TO SAMO "name", które jest w greeting.html "${name}" !!!
         */

        // w miejsce "name" (w pliku greeting.html) wstaw parametr name.
        model.addAttribute("name", name);

    //zwróć greeting.html ze wstawionym "name" (A NIE STRINGA "greeting" !!!)
        return "greeting";
    }
}

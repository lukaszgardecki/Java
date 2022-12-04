package com.example.datagenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class DataGeneratorController {
    private final DataGeneratorService service;

    public DataGeneratorController(DataGeneratorService service) {
        this.service = service;
    }


    @PostMapping("/generate-data")
    String generateData(@RequestParam int size,
                    @RequestParam String language,
                    @RequestParam(required = false) boolean firstName,
                    @RequestParam(required = false) boolean lastName,
                    @RequestParam(required = false) boolean university,
                    @RequestParam(required = false) boolean country,
                    Model model) {

        Map<String, List<String>> data = service.generateFakeData(size, language, firstName, lastName, university, country);
        model.addAttribute("data", data);
        model.addAttribute("size", size);
        return "table";
    }
}

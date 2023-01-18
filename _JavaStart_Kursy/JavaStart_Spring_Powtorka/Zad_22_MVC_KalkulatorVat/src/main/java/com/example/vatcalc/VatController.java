package com.example.vatcalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VatController {

    private final VatCalculatorService vatService;

    public VatController(VatCalculatorService vatService) {
        this.vatService = vatService;
    }

    @PostMapping("/calculate")
    String calculate(double nettoPrice, String cateogry, Model model) {
        VatDto vat = vatService.calculateBruttoPrice(nettoPrice, cateogry);
        model.addAttribute("vat", vat);
        return "result";
    }
}

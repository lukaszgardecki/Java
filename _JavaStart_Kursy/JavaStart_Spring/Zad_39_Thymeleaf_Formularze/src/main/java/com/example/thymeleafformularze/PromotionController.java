package com.example.thymeleafformularze;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class PromotionController {
    private final PromotionRepository promotionRepository;

    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @GetMapping("/add")
    String addForm(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "add-form";
    }

    @GetMapping("/update")
    String updateForm(Model model) {
        Promotion promotion = new Promotion();
        promotion.setProduct("Bułka świeża");
        promotion.setPrice(new BigDecimal("4.45"));
        promotion.setShop("Kaufland");
        promotion.setDiscountPrice(new BigDecimal("3.5"));
        model.addAttribute("promotion", promotion);
        return "add-form";
    }

    @PostMapping("/save")
    String savePromotion(Promotion promotion) {
        promotionRepository.add(promotion);
        return "redirect:/";
    }

    @GetMapping("/")
    String promotionList(Model model) {
        model.addAttribute("promotions", promotionRepository.findAll());
        return "list";
    }
}

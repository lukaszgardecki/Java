package com.example.app;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class FakeDataController {
    private final FakeDataService fakeDataService;

    public FakeDataController(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
    }

    @PostMapping("/generate-data")
    String generate(@RequestParam(required = false) int rows,
                    @RequestParam(required = false) String language,
                    @RequestParam(required = false) boolean firstName,
                    @RequestParam(required = false) boolean lastName,
                    @RequestParam(required = false) boolean university,
                    @RequestParam(required = false) boolean country,
                    Model model) {

        Map<String, List<String>> data = fakeDataService.createData(rows, language, firstName, lastName, university, country);
        model.addAttribute("data", data);
        model.addAttribute("size", rows);
        return "tablePage";
    }
}

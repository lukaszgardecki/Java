package com.mojastrona.kontrolery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TimeController {

    @RequestMapping("/current-time")
    @ResponseBody
    String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    @RequestMapping("/current-year")
    @ResponseBody
    String getYear() {
        return Integer.toString(LocalDateTime.now().getYear());
    }
}

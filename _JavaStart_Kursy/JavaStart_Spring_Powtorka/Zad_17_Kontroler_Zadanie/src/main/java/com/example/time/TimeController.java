package com.example.time;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Controller
public class TimeController {

    @RequestMapping("/current-time")
    @ResponseBody
      String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm:ss"));
    }

    @RequestMapping("/current-year")
    @ResponseBody
    Integer getCurrentYear() {
        return LocalDateTime.now().getYear();
    }
}

package com.mojastrona.get_parametryinaglowki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    @GetMapping("/hello")
    @ResponseBody
    String hello(@RequestParam(required = false, defaultValue = "stranger") String name,
                 @RequestHeader("User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "hello " + name;
    }
}

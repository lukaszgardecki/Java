package com.example.Spring_Boot_Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin!</h1>");
    }
    
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User!</h1>");
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome!</h1>");
    }




}

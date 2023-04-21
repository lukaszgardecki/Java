package com.example.app.web;

import com.example.app.message.WelcomeMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecuredController {
    private final WelcomeMessageService welcomeMessageService;

    public SecuredController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    //    @GetMapping("/")
//    String home(Authentication authentication, Model model) {
//        model.addAttribute("username", authentication.getName());
//        return "index";
//    }

//    @GetMapping("/")
//    String home(@CurrentSecurityContext SecurityContext securityContext, Model model) {
//        model.addAttribute("username", securityContext.getAuthentication().getName());
//        return "index";
//    }

//    @GetMapping("/")
//    String home(@CurrentSecurityContext(expression = "authentication.name") String name, Model model) {
//        model.addAttribute("username", name);
//        return "index";
//    }

    @GetMapping("/secured")
    String home(@RequestParam(defaultValue = "en") String lang, Model model) {
        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "secured";
    }

}

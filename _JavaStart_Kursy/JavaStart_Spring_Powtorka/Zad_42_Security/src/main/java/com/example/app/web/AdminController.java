package com.example.app.web;

import com.example.app.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String adminPanel(Model model) {
        List<String> allUserEmails = userService.findAllUserEmails();
        model.addAttribute("userEmails", allUserEmails);
        return "admin";
    }

    @GetMapping("/delete-user")
    String deleteUser(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return "redirect:/admin";
    }

}

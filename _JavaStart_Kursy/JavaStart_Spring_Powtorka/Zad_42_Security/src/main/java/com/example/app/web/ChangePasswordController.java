package com.example.app.web;

import com.example.app.user.UserService;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChangePasswordController {
    private final UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/change-password")
    String changePassword(@RequestParam String newPassword) {
        userService.changeCurrentUserPassword(newPassword);
        return "redirect:/logout";
    }
}

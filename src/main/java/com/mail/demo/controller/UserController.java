package com.mail.demo.controller;
import com.mail.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mail.demo.model.User;
import jakarta.mail.MessagingException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user/register")
    public String registerUser(User user, Model model) {
        try {
            userService.registerUser(user);
            model.addAttribute("message", "Registration successful! A confirmation email has been sent.");
        } catch (MessagingException e) {
            model.addAttribute("message", "Registration failed. Unable to send confirmation email.");
        }
        return "register";
    }
}

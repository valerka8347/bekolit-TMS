package com.example.bekolittms.controller;

import com.example.bekolittms.entity.User;
import com.example.bekolittms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(User user) {
        userService.save(user);
        return "reg";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

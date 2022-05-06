package com.example.bekolittms.controller;

import com.example.bekolittms.entity.Role;
import com.example.bekolittms.entity.User;
import com.example.bekolittms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
    model.addAttribute("users", userRepository.findAll());
        return "userList";

    }


}

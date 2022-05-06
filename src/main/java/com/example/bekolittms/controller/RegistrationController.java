package com.example.bekolittms.controller;

import com.example.bekolittms.entity.Role;
import com.example.bekolittms.entity.User;
import com.example.bekolittms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addNewUser(User user, Model model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.addAttribute("message", "User exist");
            return "reg";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
//        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String homeWork(){
        return "redirect:/home";
    }
}

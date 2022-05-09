package com.example.bekolittms.controller;

import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
    model.addAttribute("users", userRepository.findAll());
        return "userList";

    }


}

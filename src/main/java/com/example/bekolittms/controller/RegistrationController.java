package com.example.bekolittms.controller;

import com.example.bekolittms.entity.RoleEntity;
import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.repository.UserRepository;
import com.example.bekolittms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final UserService userService;

    public RegistrationController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addNewUser(UserEntity user, Model model) {
        UserEntity userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.addAttribute("message", "User exist");
            return "reg";
        }
        user.setRoles(Collections.singleton(RoleEntity.USER));
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

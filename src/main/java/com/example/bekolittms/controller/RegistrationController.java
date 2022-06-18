package com.example.bekolittms.controller;

import com.example.bekolittms.converter.UserRegistrationToUserEntityConverter;
import com.example.bekolittms.entity.RoleEntity;
import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.model.UserLogin;
import com.example.bekolittms.model.UserRegistration;
import com.example.bekolittms.repository.UserRepository;
import com.example.bekolittms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserRegistrationToUserEntityConverter userRegistrationToUserEntityConverter;

    public RegistrationController(UserRepository userRepository, UserService userService, UserRegistrationToUserEntityConverter userRegistrationToUserEntityConverter) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.userRegistrationToUserEntityConverter = userRegistrationToUserEntityConverter;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addNewUser(@ModelAttribute("user")@Valid UserRegistration userRegistration,BindingResult result , Model model) {
        UserEntity userFromDb = userRepository.findByUsername(userRegistration.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "Пользователь с таким username уже существует");
            return "reg";
        }

        userRegistration.setRoles(Collections.singleton(RoleEntity.USER));
        userService.save(userRegistrationToUserEntityConverter.convert(userRegistration));
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validLogin(@Valid UserLogin userLogin) {
        return "login";
    }

}

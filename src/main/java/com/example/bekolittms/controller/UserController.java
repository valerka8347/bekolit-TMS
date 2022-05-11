package com.example.bekolittms.controller;

import com.example.bekolittms.entity.RoleEntity;
import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.model.UserEdit;
import com.example.bekolittms.repository.UserRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable UserEntity user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", RoleEntity.values());
        model.addAttribute("userEdit", new UserEdit());
        return "userEdit";

    }

    @PostMapping("/edit")
    public String editUser(@Valid @ModelAttribute("userEdit") UserEdit userEdit, BindingResult result, Model model) {


        Optional<UserEntity> optionalUserEntity = userRepository.findById(userEdit.getId());
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            if (result.hasErrors()){
                model.addAttribute("user", userEntity);
                model.addAttribute("roles", RoleEntity.values());
                return "userEdit";
            }

            userEntity.setUsername(userEdit.getUsername());
            userEntity.setRoles(userEdit.getRoles());
            userRepository.save(userEntity);
        }

        return "redirect:/user";
    }
}

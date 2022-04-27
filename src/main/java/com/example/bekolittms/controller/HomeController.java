package com.example.bekolittms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private static final String PATH_HOME_TEMPLATE = "home.html";

    @GetMapping
    public String getHomeTemplate() {
        return PATH_HOME_TEMPLATE;
    }

}

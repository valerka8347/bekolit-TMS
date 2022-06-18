package com.example.bekolittms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Bekolit");
        return "home";
    }
    @GetMapping ("/services")
    public String services (Model model){
        model.addAttribute("title", "О нас");
        return "services";
    }
    @GetMapping("/calc-stavka")
    public String calcStavka(Model model){
        model.addAttribute("title", "Заказ ставки");
        return "stavka";
    }
}

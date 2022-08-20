package com.example.demospring1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "http://google.com");
        return "index";
    }

}

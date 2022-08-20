package com.example.demospring1.controller;
import com.example.demospring1.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("viewfile")
    public String calculator(
            @RequestParam(value = "a",required = false) Integer a,
            @RequestParam(value = "b",required = false) Integer b,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            Model model) {
        model.addAttribute("sum", calculatorService.add(a, b));
        return "viewfile";
    }
}


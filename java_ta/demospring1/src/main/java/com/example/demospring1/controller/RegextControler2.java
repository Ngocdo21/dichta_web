package com.example.demospring1.controller;

import com.example.demospring1.service.RegexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/regex")
public class RegextControler2 {
    @Autowired
    RegexService regexService;
    @GetMapping("/index2")
    public String Regex(
            @RequestParam(value = "testData", required = false) String testData,
            @RequestParam(value = "regexValue", required = false) String regexValue,
            Model model) {

        if(regexValue ==null || testData==null){
            model.addAttribute("list", new ArrayList<>());
            return "regex2";
        }

        List<String> list = regexService.findRegex(regexValue, testData);
        model.addAttribute("list", list);
        model.addAttribute("existMacth", list.size() > 0 ? "Exist" : "Not exist");
        return "regex2";
    }
}

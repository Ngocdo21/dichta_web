package com.example.demospring1.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public  Integer add(Integer a, Integer b) {
        if (a == null || b == null) {
            return null;
        }
        return a+b;
    }
}


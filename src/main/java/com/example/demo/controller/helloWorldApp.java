package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldApp {
    @RequestMapping("/getMessage")
    public String helloWorld() {
        return "Hello World";
    }
}

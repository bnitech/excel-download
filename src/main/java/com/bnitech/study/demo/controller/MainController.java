package com.bnitech.study.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public String getPage() {
        return "Get Page!";
    }
}

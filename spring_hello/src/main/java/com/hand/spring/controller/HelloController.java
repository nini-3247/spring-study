package com.hand.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/spring")
    public String helloSpring() {
        return "Hello Spring";
    }
}

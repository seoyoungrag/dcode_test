package com.itsdcode.codingtest.yrseo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@Profile("prod")
public class RedirectController {

    @GetMapping("/")
    public String redirectToRoot() {
        return "redirect:/swagger-ui.html";
    }
}
package com.songpa.songpaalgo.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String defaultPage() {
        return "index";
    }

    @GetMapping("/signup")
    public String signupPage() {
        System.out.println("hihihi");
        return "signup";
    }

}

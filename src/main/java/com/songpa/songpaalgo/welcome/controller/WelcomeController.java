package com.songpa.songpaalgo.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    // 홈으로 이동
    @GetMapping("/")
    public String defaultPage() {
        return "index";
    }

    // 회원가입 페이지 이동
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

}

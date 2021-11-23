package com.songpa.songpaalgo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardWelcomeController {

    @GetMapping("/main")
    public String boardPage() {
        return "boardmain";
    }

}

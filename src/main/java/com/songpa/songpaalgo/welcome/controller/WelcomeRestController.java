package com.songpa.songpaalgo.welcome.controller;

import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import com.songpa.songpaalgo.welcome.dto.LoginInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeRestController {

    @PostMapping("/check")
    public ResponseEntity<LoginInfoDto> userIdDuplicateCheck(@RequestBody LoginInfoDto getInfo) {

        System.out.println("hihihih~~~~~~~ " + getInfo.getUserid());
        LoginInfoDto result = new LoginInfoDto("aa");
        return ResponseEntity.ok(result);
    }

}

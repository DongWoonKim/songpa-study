package com.songpa.songpaalgo.welcome.controller;

import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import com.songpa.songpaalgo.welcome.dto.LoginInfoDto;
import com.songpa.songpaalgo.welcome.service.LoginInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/login-info/v1")
@RequiredArgsConstructor
@RestController
public class LoginInfoRestController {

    private final LoginInfoService loginInfoService;

    /**
     *
     * @param getInfo
     * @return
     * @DES : 아이디 중복체크
     */
    @PostMapping("/check")
    public ResponseEntity<LoginInfoDto> userIdDuplicateCheck(@RequestBody LoginInfoDto getInfo) {

        return ResponseEntity.ok(null);
    }

    /**
     *
     * @param loginInfoDto
     * @return
     * @DES : 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody LoginInfoDto loginInfoDto) {
        String userId = loginInfoService.signup(loginInfoDto);
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfoDto> login(@RequestBody LoginInfoDto loginInfoDto) {
        return ResponseEntity.ok(loginInfoService.login(loginInfoDto));
    }

}

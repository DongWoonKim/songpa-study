package com.songpa.songpaalgo.welcome.service;

import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import com.songpa.songpaalgo.welcome.dto.LoginInfoDto;
import com.songpa.songpaalgo.welcome.repository.LoginInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginInfoService {

    private final LoginInfoRepository loginInfoRepository;

    @Transactional
    public String signup(LoginInfoDto loginInfoDto) {
        return loginInfoRepository.save(loginInfoDto.toEntity()).getUserid();
    }

    @Transactional
    public LoginInfoDto login(LoginInfoDto loginInfoDto) {

        Optional<LoginInfo> userInfo = loginInfoRepository.findByUserid(loginInfoDto.getUserid());

        if ( userInfo.isPresent() && userInfo.get().getUserpw().equals(loginInfoDto.getUserpw()) ) {
            return LoginInfoDto.builder()
                    .userid(userInfo.get().getUserid())
                    .username(userInfo.get().getUsername())
                    .userpw(userInfo.get().getUserpw())
                    .build();
        }

        return null;
    }

}

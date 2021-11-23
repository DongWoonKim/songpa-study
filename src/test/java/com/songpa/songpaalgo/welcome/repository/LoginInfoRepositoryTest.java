package com.songpa.songpaalgo.welcome.repository;

import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginInfoRepositoryTest {

    @Autowired
    LoginInfoRepository loginInfoRepository;

    @After // 테스트 단위가 끝날 때마다 수행되는 메서드
    public void cleanup() {
        loginInfoRepository.deleteAll();
    }

    @Test
    public void 회원정보저장_불러오기() {

        // given
        String userid   = "1234";
        String username = "홍길동";
        String userpw   = "1234";
        String usermail = "1234";

        loginInfoRepository.save(
                LoginInfo.builder()
                        .userid(userid)
                        .username(username)
                        .userpw(userpw)
                        .build()
        );

        // when
        List<LoginInfo> loginInfoList = loginInfoRepository.findAll();

        // then
        LoginInfo loginInfo = loginInfoList.get(0);
        assertThat(loginInfo.getUserid()).isEqualTo("1234");
        assertThat(loginInfo.getUsername()).isEqualTo("홍길동");
        assertThat(loginInfo.getUserpw()).isEqualTo("1234");
    }

}
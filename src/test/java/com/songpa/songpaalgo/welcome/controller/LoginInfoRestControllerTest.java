package com.songpa.songpaalgo.welcome.controller;

import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import com.songpa.songpaalgo.welcome.dto.LoginInfoDto;
import com.songpa.songpaalgo.welcome.repository.LoginInfoRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginInfoRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @After
    public void tearDown() throws Exception {
        loginInfoRepository.deleteAll();
    }

    @Test
    public void Posts_회원가입() throws Exception {

        // given
        String userid   = "홍길동";
        String username = "123";
        String userpw   = "123";

        LoginInfoDto loginInfoDto = LoginInfoDto.builder()
                .userid(userid)
                .username(username)
                .userpw(userpw)
                .build();

        String url = "http://localhost:" + port + "/login-info/v1/signup";

        // when
        ResponseEntity<String> responseEntity = restTemplate
                .postForEntity(url, loginInfoDto, String.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(String.valueOf(0L));

        List<LoginInfo> all = loginInfoRepository.findAll();
        assertThat(all.get(0).getUsername()).isEqualTo(username);
        assertThat(all.get(0).getUserid()).isEqualTo(userid);
        assertThat(all.get(0).getUserpw()).isEqualTo(userpw);
    }

}
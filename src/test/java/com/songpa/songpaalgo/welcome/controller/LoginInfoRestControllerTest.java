package com.songpa.songpaalgo.welcome.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import com.songpa.songpaalgo.welcome.dto.LoginInfoDto;
import com.songpa.songpaalgo.welcome.repository.LoginInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class LoginInfoRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @Before
    public void setUp() {
        loginInfoRepository.save( LoginInfo.builder()
                        .userid("123")
                        .userpw("123")
                        .username("홍길동")
                        .build() );
    }

    // 테스트 후 테스트했던 모든 데이터를 지워준다.
//    @After
    public void tearDown() throws Exception {
        loginInfoRepository.deleteAll();
    }

    @Test
    public void Posts_회원가입() throws Exception {
        /*
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
         */

        // given
        String userid   = "홍길동";
        String username = "123";
        String userpw   = "123";

        String object = objectMapper.writeValueAsString(
                LoginInfoDto.builder()
                        .username(username)
                        .userid(userid)
                        .userpw(userpw)
                        .build()
        );

        // when
        ResultActions actions = mockMvc.perform(
                post("/login-info/v1/signup")
                        .content(object)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        actions
                .andDo(print())
                .andExpect(status().isOk())
                .equals("123");

    }

    @Test
    public void Posts_로그인() throws Exception {

        // given
        String object = objectMapper.writeValueAsString(
                LoginInfoDto.builder()
                        .userid("123")
                        .userpw("123")
                        .build()
        );

        // when
        ResultActions actions = mockMvc.perform(
                post("/login-info/v1/login")
                        .content(object)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        actions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userpw").value("123"));
    }

}
package com.songpa.songpaalgo.welcome.dto;

import com.songpa.songpaalgo.welcome.domain.LoginInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginInfoDto {

    private Long id;
    private String userid;
    private String userpw;
    private String username;

    @Builder
    public LoginInfoDto(Long id, String userid, String userpw, String username) {
        this.id     = id;
        this.userid = userid;
        this.userpw = userpw;
        this.username = username;
    }

    public LoginInfo toEntity() {
        return LoginInfo.builder()
                .userid(userid)
                .username(username)
                .userpw(userpw)
                .build();
    }

}

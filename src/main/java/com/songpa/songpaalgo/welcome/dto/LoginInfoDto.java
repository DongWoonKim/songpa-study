package com.songpa.songpaalgo.welcome.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginInfoDto {

    private String userid;
    private String userpw;

    @Builder
    public LoginInfoDto( String userid ) {
        this.userid = userid;
    }

}

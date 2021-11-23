package com.songpa.songpaalgo.welcome.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@Entity
public class LoginInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userid;

    @Column
    private String userpw;

    @Column
    private String username;

    @Builder
    public LoginInfo(String userid, String userpw, String username) {
        this.userid = userid;
        this.userpw = userpw;
        this.username = username;
    }
}

package com.songpa.songpaalgo.welcome.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class LoginInfo {

    @Id
    @Column
    private String userid;

    @Column
    private String userpw;

    @Column
    private String username;

    @Column
    private String useremail;

}

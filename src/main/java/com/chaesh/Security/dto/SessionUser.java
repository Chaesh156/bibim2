package com.chaesh.Security.dto;

import com.chaesh.Domain.member.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String email;
    private String picture;

    public SessionUser(Member member){
        this.email = member.getEmail();
        this.picture = member.getProfileUrl();

    }
}

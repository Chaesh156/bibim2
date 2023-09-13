package com.chaesh.Domain.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String profileUrl;

    private Long planSuccessCount;

    private String firebaseToken;


    @Builder
    public Member(String email, String profileUrl, Long planSuccessCount, String firebaseToken){
        this.email = email;
        this.profileUrl = profileUrl;
        this.planSuccessCount = planSuccessCount;
        this.firebaseToken = firebaseToken;
    }
}

package com.chaesh.Domain.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
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


    @Builder
    public Member(String email, String profileUrl, Long planSuccessCount){
        this.email = email;
        this.profileUrl = profileUrl;
        this.planSuccessCount = planSuccessCount;
    }
}

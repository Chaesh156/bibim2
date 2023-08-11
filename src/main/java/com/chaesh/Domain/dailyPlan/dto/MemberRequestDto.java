package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String email;
    private String profileUrl;
    private Long planSuccessCount;

    @Builder
    public MemberRequestDto(String email,String profileUrl, Long planSuccessCount){
        this.email = email;
        this.profileUrl = profileUrl;
        this.planSuccessCount = planSuccessCount;
    }

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .profileUrl(profileUrl)
                .planSuccessCount(planSuccessCount)
                .build();
    }
}

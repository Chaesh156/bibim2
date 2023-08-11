package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String email;
    private String profileUrl;
    private Long planSuccessCount;

    @Builder
    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.email = member.getEmail();
        this.profileUrl = member.getProfileUrl();
        this.planSuccessCount = member.getPlanSuccessCount();
    }
}

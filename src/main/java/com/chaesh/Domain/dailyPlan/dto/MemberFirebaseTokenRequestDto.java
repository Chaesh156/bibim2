package com.chaesh.Domain.dailyPlan.dto;


import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberFirebaseTokenRequestDto {
    private String FirebaseToken;

    @Builder
    public MemberFirebaseTokenRequestDto(String FirebaseToken){
        this.FirebaseToken = FirebaseToken;
    }
}

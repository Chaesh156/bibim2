package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DailyPlanResponseDto {
    private Long id;
    private Long member;
    private Long month;
    private Long date;

    @Builder
    public DailyPlanResponseDto(DailyPlan dailyPlan){
        this.id = dailyPlan.getId();
        this.member = dailyPlan.getMember();
        this.month = dailyPlan.getYear_month();
        this.date = dailyPlan.getDate();
    }
}

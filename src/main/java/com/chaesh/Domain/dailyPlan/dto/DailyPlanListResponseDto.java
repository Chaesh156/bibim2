package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import com.chaesh.Domain.member.Member;
import lombok.Getter;

@Getter
public class DailyPlanListResponseDto {
    private Long id;
    private Long member;
    private Long month;
    private Long date;

    public DailyPlanListResponseDto(DailyPlan entity){
        this.id = entity.getId();
        this.member = entity.getMember();
        this.month = entity.getYear_month();
        this.date = entity.getDate();
    }
}

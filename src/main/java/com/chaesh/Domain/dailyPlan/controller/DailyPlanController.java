package com.chaesh.Domain.dailyPlan.controller;

import com.chaesh.Domain.dailyPlan.dto.DailyPlanListResponseDto;
import com.chaesh.Domain.dailyPlan.dto.DailyPlanResponseDto;
import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import com.chaesh.Domain.dailyPlan.entity.DailyPlanRepository;
import com.chaesh.Domain.dailyPlan.service.DailyPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DailyPlanController {

    private final DailyPlanService dailyPlanService;

    @PostMapping("/dailyplan/{member_id}/date={date}")
    public long save(@PathVariable Long member_id, @PathVariable String date){
        return dailyPlanService.save(member_id,date);
    }

    @GetMapping("/dailyplan/{dailyPlanId}")
    public DailyPlanResponseDto findById(@PathVariable Long dailyPlanId){
        return dailyPlanService.findById(dailyPlanId);
    }

    @DeleteMapping("/dailyplan/{dailyPlanId}")
    public Long delete(@PathVariable Long dailyPlanId){
        dailyPlanService.delete(dailyPlanId);
        return dailyPlanId;
    }

    @GetMapping("/dailyplan/{memberId}/{month}")
    public List<DailyPlanListResponseDto> findAllMonth(@PathVariable Long memberId, @PathVariable String month){
        return dailyPlanService.findByMonth(memberId,month);
    }
}

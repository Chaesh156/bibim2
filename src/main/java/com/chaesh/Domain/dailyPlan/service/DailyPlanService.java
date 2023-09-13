package com.chaesh.Domain.dailyPlan.service;

import com.chaesh.Domain.dailyPlan.dto.DailyPlanListResponseDto;
import com.chaesh.Domain.dailyPlan.dto.DailyPlanResponseDto;
import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import com.chaesh.Domain.dailyPlan.entity.DailyPlanRepository;
import com.chaesh.Global.error.exception.DailyPlanNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DailyPlanService {
    private final DailyPlanRepository dailyPlanRepository;

    @Transactional
    public long save(Long memberId, String date) throws RuntimeException{
        DailyPlan plan = new DailyPlan();
        plan.setMember(memberId);
        plan.setYear_month(Long.parseLong(date.substring(0,6)));
        plan.setDate(Long.parseLong(date.substring(6)));

        return dailyPlanRepository.save(plan).getId();
    }

    public DailyPlanResponseDto findById(Long id){
        DailyPlan entity = dailyPlanRepository.findById(id)
                .orElseThrow(()-> new DailyPlanNotExistException("해당 plan이 없습니다. id =" +id));
        return new DailyPlanResponseDto(entity);
    }

    @Transactional
    public List<DailyPlanListResponseDto> findByMonth(Long id, String month){
       return dailyPlanRepository.findAllMonth(id).stream()
               .map(DailyPlanListResponseDto::new)
               .collect(Collectors.toList());
    }

    public void delete(Long id){
        DailyPlan plan = dailyPlanRepository.findById(id)
                .orElseThrow(() -> new DailyPlanNotExistException("해당 plan이 없습니다. id=" +id));
        dailyPlanRepository.delete(plan);
    }
}

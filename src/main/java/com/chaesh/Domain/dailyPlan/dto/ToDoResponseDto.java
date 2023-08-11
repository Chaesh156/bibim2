package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.category.Category;
import com.chaesh.Domain.member.Member;
import com.chaesh.Domain.toDo.ToDo;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoResponseDto {
    private Long id;
    private Long categoryId;
    private Long dailyPlanId;
    private String title;
    private Boolean isComplete;
    private String alarmStartTime;
    private String  alarmEndTime;

    @Builder
    public ToDoResponseDto(ToDo toDo){
        this.id = toDo.getId();
        this.categoryId = toDo.getCategory().getPk();
        this.dailyPlanId = toDo.getDailyPlan().getId();
        this.title = toDo.getTitle();
        this.isComplete = toDo.getIsComplete();
        this.alarmStartTime = toDo.getAlarmStartTime();
        this.alarmEndTime = toDo.getAlarmEndTime();

    }

}

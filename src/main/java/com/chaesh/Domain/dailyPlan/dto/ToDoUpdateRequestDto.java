package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.toDo.ToDo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoUpdateRequestDto {
    private String title;
    private String alarmStartTime;
    private String alarmEndTime;
    private Boolean isComplete;

    @Builder
    public ToDoUpdateRequestDto(ToDo entity){
        this.title = entity.getTitle();
        this.alarmStartTime = entity.getAlarmStartTime();
        this.alarmEndTime = entity.getAlarmEndTime();
        this.isComplete = entity.getIsComplete();
    }
}

package com.chaesh.Domain.dailyPlan.dto;

import com.chaesh.Domain.toDo.ToDo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoSaveRequestDto {

    private String title;
    private String alarmStartTime;
    private String alarmEndTime;
    private Boolean isComplete;

    @Builder
    public ToDoSaveRequestDto(String title, String alarmStartTime, String alarmEndTime, Boolean isComplete){
        this.title = title;
        this.alarmStartTime = alarmStartTime;
        this.alarmEndTime = alarmEndTime;
        this.isComplete = isComplete;
    }

    public ToDo toEntity(){
        return ToDo.builder()
                .title(title)
                .alarmStartTime(alarmStartTime)
                .alarmEndTime(alarmEndTime)
                .isComplete(isComplete)
                .build();
    }
}

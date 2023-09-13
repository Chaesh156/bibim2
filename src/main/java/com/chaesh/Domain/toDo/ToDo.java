package com.chaesh.Domain.toDo;

import com.chaesh.Domain.category.Category;
import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Category category;

    @ManyToOne
    @JoinColumn(name = "DAILYPLAN_ID")
    private DailyPlan dailyPlan;

    private String title;
    private Boolean isComplete;
    private String alarmStartTime;
    private String  alarmEndTime;

    @Builder
    public ToDo(String title,Boolean isComplete, String alarmStartTime, String alarmEndTime){
        this.title = title;
        this.isComplete = isComplete;
        this.alarmStartTime = alarmStartTime;
        this.alarmEndTime = alarmEndTime;
    }

    public void update(String title,Boolean isComplete, String alarmStartTime, String alarmEndTime){
        this.title = title;
        this.isComplete = isComplete;
        this.alarmStartTime = alarmStartTime;
        this.alarmEndTime = alarmEndTime;
    }

    public void check(Long check){
    }
}


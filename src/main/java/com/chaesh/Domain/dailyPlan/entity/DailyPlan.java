package com.chaesh.Domain.dailyPlan.entity;

import com.chaesh.Domain.BaseTimeEntity;
import com.chaesh.Domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class DailyPlan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long member;

    private Long year_month;
    private Long date;
}

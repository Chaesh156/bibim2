package com.chaesh.Domain.dailyPlan.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPlanRepository extends JpaRepository<DailyPlan,Long> {
    @Query("SELECT d FROM DailyPlan d ORDER BY d.id ")
    List<DailyPlan> findAll();

    @Query("SELECT d FROM DailyPlan d ORDER BY d.year_month desc ")
    List<DailyPlan> findAllMonth();
}

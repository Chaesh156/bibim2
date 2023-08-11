package com.chaesh.Domain.toDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    @Query("SELECT t FROM ToDo t")
    List<ToDo> findAllByDailyPlan();
}

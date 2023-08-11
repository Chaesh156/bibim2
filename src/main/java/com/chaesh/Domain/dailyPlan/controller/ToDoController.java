package com.chaesh.Domain.dailyPlan.controller;

import com.chaesh.Domain.dailyPlan.dto.ToDoListResponseDto;
import com.chaesh.Domain.dailyPlan.dto.ToDoResponseDto;
import com.chaesh.Domain.dailyPlan.dto.ToDoSaveRequestDto;
import com.chaesh.Domain.dailyPlan.dto.ToDoUpdateRequestDto;
import com.chaesh.Domain.dailyPlan.service.ToDoService;
import com.chaesh.Domain.toDo.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/todo/{dailyplanId}")
    public Long save(@PathVariable Long dailyplanId, @RequestBody ToDoSaveRequestDto toDo){
        return toDoService.save(dailyplanId,toDo);
    }
    @PostMapping("/todo/complete/{todoId}")
    public Long complete(@PathVariable Long todoId){
        return toDoService.check(todoId,true);
    }
    @PostMapping("/todo/fail/{todoId}")
    public Long fail(@PathVariable Long todoId){
        return toDoService.check(todoId,false);
    }

    @PutMapping("/todo/{todoId}")
    public Long update(@PathVariable Long id, @RequestBody ToDoUpdateRequestDto requestDto){
        return toDoService.update(id,requestDto);
    }

    @GetMapping("/todo/{todoId}")
    public ToDoResponseDto findById(@PathVariable Long todoId){
        return toDoService.findById(todoId);
    }

    @DeleteMapping("/todo/{todoId}")
    public Long delete(@PathVariable Long todoId){
        toDoService.delete(todoId);
        return todoId;
    }

    @GetMapping("/todo/{dailyplanId}/list")
    public List<ToDoListResponseDto> findByDay(@PathVariable Long dailyplanId){
        return toDoService.findByDay(dailyplanId);
    }
}

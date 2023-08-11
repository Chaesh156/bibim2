package com.chaesh.Domain.dailyPlan.service;

import com.chaesh.Domain.category.CategoryCode;
import com.chaesh.Domain.dailyPlan.dto.ToDoListResponseDto;
import com.chaesh.Domain.dailyPlan.dto.ToDoResponseDto;
import com.chaesh.Domain.dailyPlan.dto.ToDoSaveRequestDto;
import com.chaesh.Domain.dailyPlan.dto.ToDoUpdateRequestDto;
import com.chaesh.Domain.dailyPlan.entity.DailyPlan;
import com.chaesh.Domain.dailyPlan.entity.DailyPlanRepository;
import com.chaesh.Domain.toDo.ToDo;
import com.chaesh.Domain.toDo.ToDoRepository;
import com.chaesh.Global.error.exception.DailyPlanNotExistException;
import com.chaesh.Global.error.exception.ToDoNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final DailyPlanRepository dailyPlanRepository;
    private final CategoryService categoryService;

    @Transactional
    public Long save(Long planId, ToDoSaveRequestDto requestDto) throws RuntimeException{
        ToDo toDo = requestDto.toEntity();
        DailyPlan plan = dailyPlanRepository.findById(planId)
                .orElseThrow(()-> new DailyPlanNotExistException("해당 plan이 없습니다. id =" +planId));


        toDo.setDailyPlan(plan);
        categoryService.save(toDo.getId(), CategoryCode.DAILY);
        return toDoRepository.save(toDo).getId();
    }

    @Transactional
    public Long update(Long id, ToDoUpdateRequestDto requestDto){
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new ToDoNotExistException("해당 id를 가진 todo가 없습니다. id=" +id));

        todo.update(requestDto.getTitle(),requestDto.getIsComplete(),requestDto.getAlarmStartTime(),requestDto.getAlarmEndTime());

        return id;
    }

    @Transactional
    public Long check(Long id, Boolean isComplete){
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ToDoNotExistException("해당 id를 가진 todo가 없습니다. id=" +id));

        toDo.update(toDo.getTitle(),isComplete, toDo.getAlarmStartTime(), toDo.getAlarmEndTime());

        return id;
    }

    public ToDoResponseDto findById(Long id){
        ToDo entity = toDoRepository.findById(id)
                .orElseThrow(() -> new ToDoNotExistException("해당 id를 가진 todo가 없습니다. id=" +id));

        return new ToDoResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ToDoListResponseDto> findByDay(Long id){
        return toDoRepository.findAllByDailyPlan().stream()
                .map(ToDoListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new ToDoNotExistException("해당 id를 가진 todo가 없습니다. id=" +id));

        toDoRepository.delete(todo);
    }

}

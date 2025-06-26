package com.practice.task.service;

import com.practice.task.dto.TaskDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TaskService {

    TaskDto getTaskById(Long taskId);

    List<TaskDto> getAllTasks(Pageable pageable);

    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> createAllTasks(List<TaskDto> taskDtoList);

    TaskDto updateTaskById(Long taskId, TaskDto taskDto);

    List<TaskDto> updateAllTasks(List<TaskDto> taskDtoList);

    void deleteTaskById(Long taskId);

    void deleteAllTasks(List<Long> taskIds);
}

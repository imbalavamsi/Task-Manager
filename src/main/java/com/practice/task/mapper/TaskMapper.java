package com.practice.task.mapper;

import com.practice.task.dto.TaskDto;
import com.practice.task.entity.Task;

public class TaskMapper {

    public static TaskDto toDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted());
    }

    public static Task toEntity(TaskDto taskDto) {
        return new Task(taskDto.id(), taskDto.title(), taskDto.description(), taskDto.completed());
    }
}

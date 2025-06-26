package com.practice.task.service.impl;

import com.practice.task.dto.TaskDto;
import com.practice.task.entity.Task;
import com.practice.task.exception.TaskNotFoundException;
import com.practice.task.mapper.TaskMapper;
import com.practice.task.repo.TaskRepo;
import com.practice.task.service.TaskService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo repo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.repo = taskRepo;
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = repo.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID: " + taskId + " is not found"));
        return TaskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks(Pageable pageable) {
        return repo.findAll(pageable)
                .stream()
                .map(TaskMapper::toDto)
                .toList();
    }


    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task savedTask = repo.save(TaskMapper.toEntity(taskDto));
        return TaskMapper.toDto(savedTask);
    }

    @Override
    public List<TaskDto> createAllTasks(List<TaskDto> taskDtoList) {
        List<Task> taskEntities = taskDtoList.stream()
                .map(TaskMapper::toEntity)
                .toList();

        List<Task> savedTasks = repo.saveAll(taskEntities);

        return savedTasks.stream()
                .map(TaskMapper::toDto)
                .toList();
    }

    @Override
    public TaskDto updateTaskById(Long taskId, TaskDto taskDto) {
        Task existingTask = repo.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID: " + taskId + " is not found"));

        existingTask.setTitle(taskDto.title());
        existingTask.setDescription(taskDto.description());
        existingTask.setCompleted(taskDto.completed());

        Task updatedTask = repo.save(existingTask);
        return TaskMapper.toDto(updatedTask);
    }

    @Override
    public List<TaskDto> updateAllTasks(List<TaskDto> taskDtoList) {
        return taskDtoList.stream()
                .map(dto -> updateTaskById(dto.id(), dto))
                .toList();
    }

    @Override
    public void deleteTaskById(Long taskId) {
        repo.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID: " + taskId + " is not found"));
        repo.deleteById(taskId);
    }

    @Override
    public void deleteAllTasks(List<Long> taskIds) {
        taskIds.forEach(this::deleteTaskById);
    }
}

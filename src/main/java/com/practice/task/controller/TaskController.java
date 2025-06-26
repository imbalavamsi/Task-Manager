package com.practice.task.controller;

import com.practice.task.dto.TaskDto;
import com.practice.task.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task API", description = "Manage tasks with CRUD operations")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Operation(summary = "Get all tasks with pagination support")
    public ResponseEntity<List<TaskDto>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<TaskDto> tasks = taskService.getAllTasks(pageable);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new task")
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @PostMapping("/bulk")
    @Operation(summary = "Create multiple tasks")
    public ResponseEntity<List<TaskDto>> createAllTasks(@Valid @RequestBody List<@Valid TaskDto> taskDtoList) {
        return ResponseEntity.ok(taskService.createAllTasks(taskDtoList));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update task by ID")
    public ResponseEntity<TaskDto> updateTaskById(@PathVariable Long id, @Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTaskById(id, taskDto));
    }

    @PutMapping("/bulk")
    @Operation(summary = "Update multiple tasks")
    public ResponseEntity<List<TaskDto>> updateAllTasks(@Valid @RequestBody List<@Valid TaskDto> taskDtoList) {
        return ResponseEntity.ok(taskService.updateAllTasks(taskDtoList));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete task by ID")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bulk")
    @Operation(summary = "Delete multiple tasks by IDs")
    public ResponseEntity<Void> deleteAllTasks(@RequestBody List<Long> taskIds) {
        taskService.deleteAllTasks(taskIds);
        return ResponseEntity.noContent().build();
    }
}

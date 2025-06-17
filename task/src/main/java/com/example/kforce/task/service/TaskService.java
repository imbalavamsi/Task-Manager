package com.example.kforce.task.service;

import com.example.kforce.task.model.Task;
import com.example.kforce.task.repo.TaskRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    public List<Task> getTasks() {
        return repo.findAll();
    }

    public Task getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Task updated) {
        Task task = getById(id);
        task.setTitle(updated.getTitle());
        task.setDescription(updated.getDescription());
        task.setCompleted(updated.isCompleted());
        return repo.save(task);
    }

    public void deleteById(Long id) {
        getById(id);
        repo.deleteById(id);
    }
}

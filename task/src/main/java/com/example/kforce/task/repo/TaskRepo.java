package com.example.kforce.task.repo;

import com.example.kforce.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}

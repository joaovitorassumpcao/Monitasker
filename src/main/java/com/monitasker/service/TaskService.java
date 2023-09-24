package com.monitasker.service;

import com.monitasker.model.entity.Task;
import com.monitasker.model.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> findByUserId(Long userId) {
        return taskRepository.findByUser_Tasks_User_Id(userId);
    }
}

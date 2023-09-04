package com.monitasker.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.monitasker.entity.Task;
import com.monitasker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

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

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task modifiedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) return Optional.of(taskRepository.save(modifiedTask));
        else Optional.empty();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

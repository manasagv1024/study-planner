package com.studyplanner.planner.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyplanner.planner.model.Task;
import com.studyplanner.planner.repository.TaskRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
   @DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id){
    System.out.println("Deleting ID: " + id);
    taskRepository.deleteById(id);
}
@PutMapping("/{id}")
public Task updateStatus(@PathVariable Long id) {
    Task task = taskRepository.findById(id).orElse(null);

    if (task != null) {
        task.setStatus("Completed");
        return taskRepository.save(task);
    }

    return null;
}
}
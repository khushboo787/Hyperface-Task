package com.khushboo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khushboo.dto.TaskRequest;
import com.khushboo.model.Task;
import com.khushboo.service.TaskService;

import java.util.List;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    
    @Autowired
    public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}


	@PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@Valid @RequestBody TaskRequest request) {
          Task task = taskService.addTask(request.getDescription());
        return ResponseEntity.ok(task);
    }

     
    @PutMapping("/markTaskAsComplete/{id}")
    public ResponseEntity<Task> markTaskAsComplete(@PathVariable int id) {
        Task updatedTask = taskService.markTaskAsComplete(id);
        return ResponseEntity.ok(updatedTask);
    }

     
    @DeleteMapping("/deleteTaskById/{id}")
    public ResponseEntity<String> removeTask(@PathVariable int id) {
     String response= taskService.removeTask(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


     
    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    
}
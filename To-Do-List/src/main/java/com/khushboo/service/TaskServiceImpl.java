package com.khushboo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushboo.exception.TaskNotFoundException;
import com.khushboo.model.Task;
import com.khushboo.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl  implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    
    public Task addTask(String description) {
        Task task = new Task(description);
        return taskRepository.save(task);
    }

    
    
    
    public Task markTaskAsComplete(int id) {
    	
    	 Task task = taskRepository.findById(id)
                 .orElseThrow(() -> new TaskNotFoundException("Task not found with this ID: " + id));
         task.setCompleted(true);
        return taskRepository.save(task);
    }
    
    
   
     
    public String removeTask(int id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with this ID: " + id);
        }
        taskRepository.deleteById(id);
        return "Task with ID " + id + " deleted successfully.";
    }


     
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    
}
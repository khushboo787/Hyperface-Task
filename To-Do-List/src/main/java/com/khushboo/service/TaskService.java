package com.khushboo.service;

import java.util.List;

import com.khushboo.model.Task;

public interface TaskService {
	
	  public Task addTask(String description);
	  public Task markTaskAsComplete(int id);
	  public String removeTask(int id);
	  public List<Task> getAllTasks();
	  
}

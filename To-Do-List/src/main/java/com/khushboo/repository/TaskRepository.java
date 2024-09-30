package com.khushboo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khushboo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
     
}
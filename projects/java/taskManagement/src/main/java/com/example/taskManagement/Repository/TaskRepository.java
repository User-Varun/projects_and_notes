package com.example.taskManagement.Repository;

import com.example.taskManagement.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task , Long> { }

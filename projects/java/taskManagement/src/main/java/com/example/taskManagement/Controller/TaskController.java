package com.example.taskManagement.Controller;


import com.example.taskManagement.Dto.AddTaskRequest;
import com.example.taskManagement.Model.Task;
import com.example.taskManagement.Service.TaskService;
import com.example.taskManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService ts;
    @Autowired
    private UserService us;




    @PostMapping()
    public ResponseEntity<Task> addTask(@Valid @RequestBody AddTaskRequest req , Authentication authentication){

        long userId = us.findUserByUsername(authentication.getName()).getId();

        Task task = ts.addTask(req.getTitle() , req.getDescription() ,userId );

        URI location = URI.create("/api/tasks/" + task.getId());

        return ResponseEntity.created(location).body(task);
    }


    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks(Authentication auth){

        long userId = us.findUserByUsername(auth.getName()).getId();

        return ResponseEntity.ok(ts.getAllTasks(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        return ResponseEntity.ok().body(ts.getTask(id));
    }
}

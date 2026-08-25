package com.example.taskManagement.Controller;


import com.example.taskManagement.Model.Task;
import com.example.taskManagement.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskService ts;


    public TaskController(TaskService ts){
        this.ts = ts;
    }

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody Task t){

        Task savedUser = ts.save(t);

        URI location = URI.create("/api/tasks/" + savedUser.getId());

        return ResponseEntity.created(location).body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){

        return ResponseEntity.ok().body(ts.getTask(id));
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(ts.getTasks());
    }
}

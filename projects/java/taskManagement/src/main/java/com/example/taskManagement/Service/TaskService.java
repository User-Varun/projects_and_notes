package com.example.taskManagement.Service;

import com.example.taskManagement.Model.Task;
import com.example.taskManagement.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository tr;


    public TaskService(TaskRepository tr){
        this.tr = tr;
    }

    public Task save(Task t){
       return tr.createTask(t);
    }

    public Task getTask(int id){
        return tr.getTask(id);
    }

    public List<Task> getTasks(){
        return tr.getTasks();
    }
}

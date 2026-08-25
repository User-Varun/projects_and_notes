package com.example.taskManagement.Repository;

import com.example.taskManagement.Model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private List<Task> tasks;


    public TaskRepository(){
        this.tasks  = new ArrayList<>();
    }

    public Task getTask(int id){

        for(Task t : tasks){
            if(id == t.getId()){
                return t;
            }
        }
        return null;
    }
    public Task createTask(Task t){
        tasks.add(t);
        return t;
    }

    public List<Task> getTasks(){
        return tasks;
    }
}

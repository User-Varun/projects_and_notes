package com.example.taskManagement.Service;

import com.example.taskManagement.Model.Task;
import com.example.taskManagement.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository tr;


    public TaskService(TaskRepository tr){
        this.tr = tr;
    }

    @Transactional
    public Task save(Task t){
       return tr.save(t);
    }

    @Transactional
    public Task getTask(long id){
        return tr.findById(id).orElseThrow(() -> new HttpMessageNotWritableException("id: " + id));
    }

    @Transactional
    public List<Task> getTasks(){
        return tr.findAll();
    }
}

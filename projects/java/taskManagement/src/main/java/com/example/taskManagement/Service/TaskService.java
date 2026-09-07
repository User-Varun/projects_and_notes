package com.example.taskManagement.Service;

import com.example.taskManagement.Model.Task;
import com.example.taskManagement.Model.User;
import com.example.taskManagement.Repository.TaskRepository;
import com.example.taskManagement.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository tr;

    @Transactional
    public Task addTask(String title , String description , Long userId){

        if(title == null || description == null || userId == null) throw new RuntimeException("Invalid given details!");

        Task t = new Task();

        t.setTitle(title);
        t.setDescription(description);
        t.setUserId(userId);

        return tr.save(t);
    }


    public Task getTask(long id){
        return tr.findById(id).orElseThrow(() -> new HttpMessageNotWritableException("id: " + id));
    }

    public List<Task> getAllTasks(Long userId){
        return tr.findAllByUserId(userId);
    }
}

package com.example.taskManagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String title;
    private  String description;
    private int projectId;
    private int userId;

    public Task(){}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getUserId() {
        return userId;
    }

    public Task(String t , String d , int projectId , int userId){

        this.title = t;
        this.description = d;
        this.userId = userId;
        this.projectId = projectId;
    }
public long getId(){
        return id;
}

}

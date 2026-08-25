package com.example.taskManagement.Model;


public class Task {

    private  int id;
    private  String title;
    private  String description;
    private int projectId;
    private int userId;

    public Task(){}

    public Task(String t , String d , int projectId , int userId){

        this.title = t;
        this.description = d;
        this.userId = userId;
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getUserId() {
        return userId;
    }

    public int getId(){
        return id;
    }


}

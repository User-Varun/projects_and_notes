package com.example.taskManagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(unique = true , nullable = false)
    private  String name;

    public User(){};

    public User(long id , String name){
        this.id = id;
        this.name = name;
    }
    public long getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

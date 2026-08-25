package com.example.taskManagement;

import com.example.taskManagement.Model.Task;
import com.example.taskManagement.Model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}









}

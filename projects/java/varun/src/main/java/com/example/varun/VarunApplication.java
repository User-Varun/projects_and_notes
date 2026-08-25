package com.example.varun;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class VarunApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarunApplication.class, args);
	}
}

@RestController
@RequestMapping("/api/products")
class prodControllers{
	@GetMapping
	public String getProducts(){
		return "Hello, World!";
	}
}
package com.example.abccollege.studentmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class StudentManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementServiceApplication.class, args);
	}

}

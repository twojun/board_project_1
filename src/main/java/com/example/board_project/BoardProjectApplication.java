package com.example.board_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)  // 기본 Security page 무시
public class BoardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardProjectApplication.class, args);
	}

}

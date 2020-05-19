package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.LibraryRepository;

@SpringBootApplication
public class LmsApplication {
		
	private LibraryRepository repo;
	

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

}

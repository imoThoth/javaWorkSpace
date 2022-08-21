package com.titans.atlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtlasApplication.class, args);
	}

//	@GetMapping
//	public List<Student> studentList(){
//		return List.of(
//				new Student(1L, "Agenor", 29,
//						LocalDate.of(1923, Month.APRIL, 6),
//						"agenor@greek.arcne.com")
//		);
//	}
}

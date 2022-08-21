package com.titans.atlas.service;

import com.titans.atlas.model.Student;
import com.titans.atlas.model.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JUNE;
import static java.util.Calendar.APRIL;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {
            Student agenor = new Student(1L, "Agenor",
                    LocalDate.of(1923, APRIL, 6),
                    "agenor@greek.arcne.com");

            Student reggie = new Student(3L, "Reginald",
                    LocalDate.of(1924, JUNE, 6),
                    "reggieReeds@hotmail.com");

            repository.saveAll(
                    List.of(agenor, reggie)
            );

        };

    }

}

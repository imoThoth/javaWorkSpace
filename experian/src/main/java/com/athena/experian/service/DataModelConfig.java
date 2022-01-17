package com.athena.experian.service;

import com.athena.experian.model.DataModel;
import com.athena.experian.model.DataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataModelConfig {

    @Bean
    CommandLineRunner commandLineRunner(DataRepository repository){

        return args -> {
            DataModel starterData = new DataModel(
                    1, "Experian",
                    LocalDateTime.now(), LocalDateTime.now(),1);

            DataModel demoData = new DataModel(
                    2, "Athena",
                    LocalDateTime.of(
                            1990, 05, 03, 13, 20, 10),
                    LocalDateTime.now(),2);

            repository.saveAll(
                    List.of(starterData, demoData)
            );
        };
    }
}

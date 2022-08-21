package com.tiamat.apsu.service;

import com.tiamat.apsu.model.Gamer;
import com.tiamat.apsu.repository.GamerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class GamerModelConfig {

    @Bean
    CommandLineRunner commandLineRunner(GamerRepository repository){

        return args -> {
            Gamer starterGamer = new Gamer(
                    1L, "PewPew", 20, true);

            Gamer demoGamer = new Gamer(
                    2L, "tron", 100, true);

            repository.saveAll(
                    List.of(starterGamer, demoGamer)
            );
        };
    }
}

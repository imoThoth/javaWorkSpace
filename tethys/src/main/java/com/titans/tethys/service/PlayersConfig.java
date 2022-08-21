package com.titans.tethys.service;

import com.titans.tethys.model.Players;
import com.titans.tethys.model.PlayersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayersConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayersRepository repository){

        return  args -> {
//            Players starter = new Players("tron", 2L);
//            Players ultron = new Players("ultron", 0L);
//
//            repository.saveAll(
//                    List.of(starter, ultron));
        };
    }
}

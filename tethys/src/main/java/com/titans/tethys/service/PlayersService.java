package com.titans.tethys.service;

import com.titans.tethys.model.Players;
import com.titans.tethys.model.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayersService {

    private final PlayersRepository playersRepository;

    @Autowired
    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public List<Players> playerList(){
        return playersRepository.findAll();
    }

    public void addNewPlayer(Players player) {
        Optional<Players> checkPlayer = playersRepository.findPlayerByName(player.getPlayer());

        if(checkPlayer.isPresent()){
            throw new IllegalArgumentException("player name is taken");
        }

        playersRepository.save(player);
    }

    public void updatePlayerScore(Long id, Integer score) {

      Players checkPlayer = playersRepository.findById(id).orElseThrow( ()->
                new IllegalArgumentException("Player id " + id + " does not exist"));

        if(Objects.equals(checkPlayer.getId(), id)){
            System.out.println(score);
           checkPlayer.setScore(checkPlayer.getScore() + 1);
        }
    }

    public void deletePlayer(Long id) {
        Optional<Players> deleteId = playersRepository.findById(id);

        if(deleteId.isPresent()){
            playersRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Id does not exist");
        }
    }
}

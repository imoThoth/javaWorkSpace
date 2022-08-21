package com.titans.tethys.controller;

import com.titans.tethys.model.Players;
import com.titans.tethys.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "tethys/v2/users")
public class PlayersController {

    private final PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping
    public List<Players> getUserList(){
        return playersService.playerList();
    }

    @PostMapping(path = "/new")
    public void addNewPlayer(@RequestBody Players player){
         playersService.addNewPlayer(player);
    }

    @PutMapping(path = "/update/{id}")
    public void updatePlayerScore(
                @PathVariable("id")Long id,
                @RequestParam() Integer score){

        playersService.updatePlayerScore(id,score);
        System.out.println("the id is " + id +" and new score is: " + score);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlayer(@PathVariable("id") Long id){
        playersService.deletePlayer(id);
    }
}

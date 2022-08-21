package com.tiamat.apsu.controller;

import com.tiamat.apsu.model.Gamer;
import com.tiamat.apsu.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "apsu/marduk")
public class GamerController {

    @Autowired
    GamerService gamerService;

//    @Autowired
//    public GamerController(GamerService gamerService) {
//        this.gamerService = gamerService;
//    }

    @PostMapping(path = "/add")
    public Gamer saveGamer(
            @RequestBody Gamer gamer){
        return gamerService.saveGamer(gamer);
    }

    @GetMapping()
    public List<Gamer> fetchGamerList(){
        return gamerService.fetchGamerList();
    }

    @PutMapping(path = "update/{id}")
    public Gamer updateGamer(
            @RequestBody Gamer gamer,
            @PathVariable("id") Long gamerId){
        return gamerService.updateGamer(gamer, gamerId);
    }

    @DeleteMapping(path = "delete/{id}")
    public String deleteDepartmentById(
            @PathVariable("id") Long gamerId){
        gamerService.deleteGamerById(gamerId);
        return "Successfully Updated";
    }

}

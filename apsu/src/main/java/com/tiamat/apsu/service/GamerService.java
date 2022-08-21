package com.tiamat.apsu.service;

import com.tiamat.apsu.model.Gamer;
import com.tiamat.apsu.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GamerService implements GamerContractService {

    @Autowired
    private GamerRepository repository;


    @Override
    public Gamer saveGamer(Gamer gamer) {
        return repository.save(gamer);
    }

    @Override
    public List<Gamer> fetchGamerList() {
        return repository.findAll();
    }

    @Override
    public Gamer updateGamer(Gamer gamer, Long gamerId) {

        Gamer gamerDB = repository.findById(gamerId).get();

        if(Objects.nonNull(gamer.getGamerName()) && !"".equalsIgnoreCase(gamer.getGamerName())){
            gamerDB.setGamerName(gamer.getGamerName());
        }

        return repository.save(gamerDB);
    }

    @Override
    public void deleteGamerById(Long gamerId) {
            repository.deleteById(gamerId);
    }
}

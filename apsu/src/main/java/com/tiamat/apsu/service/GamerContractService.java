package com.tiamat.apsu.service;

import com.tiamat.apsu.model.Gamer;

import java.util.List;

public interface GamerContractService {

    Gamer saveGamer(Gamer gamer);

    List<Gamer> fetchGamerList();

    Gamer updateGamer(Gamer gamer, Long gamerId);

    void deleteGamerById(Long gamerId);
}

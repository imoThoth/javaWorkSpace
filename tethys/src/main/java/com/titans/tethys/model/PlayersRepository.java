package com.titans.tethys.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Long> {

    @Query("SELECT p FROM Players p WHERE p.player =?1")
    Optional<Players> findPlayerByName(String name);

}

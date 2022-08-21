package com.titans.tethys.model;

import javax.persistence.*;

@Entity
@Table
public class Players {
    @Id
    @SequenceGenerator(
            name="players_sequence",
            sequenceName = "players_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "players_sequence"
    )
    private Long id;
    private String player;
    private Integer score;

    public Players(){
        this.score = 0;
    }

    public Players(String player, Long id) {
        this.player = player;
        this.id = id;
        this.score = 0;
    }


    public Players(String player) {
        this.player = player;
        this.score = 0;
    }

    public String getPlayer() {
        return player;
    }

    public Long getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Players{" +
                "playerName='" + player + '\'' +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}

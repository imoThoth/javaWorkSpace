package com.tiamat.apsu.model;

import javax.persistence.*;

@Entity
@Table
public class Gamer {

    @Id
    @SequenceGenerator(
            name = "gamers_sequence",
            sequenceName = "gamers_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gamers_sequence"
    )
    private Long gamerId;
    private String gamerName;
    private Integer gamerAge;
    private Boolean gamerState;

    public Gamer() { }

    public Gamer(String gamerName, Integer gamerAge, Boolean gamerState) {
        this.gamerName = gamerName;
        this.gamerAge = gamerAge;
        this.gamerState = gamerState;
    }

    public Gamer(Long gamerId, String gamerName, Integer gamerAge, Boolean gamerState) {
        this.gamerId = gamerId;
        this.gamerName = gamerName;
        this.gamerAge = gamerAge;
        this.gamerState = gamerState;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public void setGamerId(Long gamerId) {
        this.gamerId = gamerId;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public Integer getGamerAge() {
        return gamerAge;
    }

    public void setGamerAge(Integer gamerAge) {
        this.gamerAge = gamerAge;
    }

    public Boolean getGamerState() {
        return gamerState;
    }

    public void setGamerState(Boolean gamerState) {
        this.gamerState = gamerState;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "gamerId=" + gamerId +
                ", gamerName='" + gamerName + '\'' +
                ", gamerAge=" + gamerAge +
                ", gamerState=" + gamerState +
                '}';
    }
}

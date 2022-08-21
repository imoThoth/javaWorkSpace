package com.demoConnection.Prometheus.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class User {
    private final UUID id;
    @NotBlank
    private String name;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name) {
        this.name = name;
        this. id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
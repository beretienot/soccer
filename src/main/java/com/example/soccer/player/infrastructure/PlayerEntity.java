package com.example.soccer.player.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class PlayerEntity {
    @Id
    private String id;
    private String teamId;
    private String name;

    protected PlayerEntity() {
    }

    public PlayerEntity(String id, String teamId, String name) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }
}

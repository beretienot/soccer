package com.example.soccer.player.domain;

import com.example.soccer.team.domain.TeamId;

/**
 * Aggregate root representing a player.
 */
public class Player {
    private final PlayerId id;
    private final TeamId teamId;
    private final String name;

    public Player(PlayerId id, TeamId teamId, String name) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
    }

    public PlayerId getId() { return id; }
    public TeamId getTeamId() { return teamId; }
    public String getName() { return name; }
}

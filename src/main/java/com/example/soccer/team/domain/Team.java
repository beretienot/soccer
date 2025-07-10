package com.example.soccer.team.domain;

/**
 * Aggregate root representing a team.
 */
public class Team {
    private final TeamId id;
    private final String name;

    public Team(TeamId id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

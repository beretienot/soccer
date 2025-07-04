package com.example.soccer.domain.team;

public class TeamCreatedEvent {
    private final Team team;

    public TeamCreatedEvent(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}

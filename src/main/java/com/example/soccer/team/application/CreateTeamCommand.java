package com.example.soccer.team.application;

import com.example.soccer.shared.application.Command;
import com.example.soccer.team.domain.TeamId;

public class CreateTeamCommand implements Command<TeamId> {
    private final TeamId id;
    private final String name;

    public CreateTeamCommand(TeamId id, String name) {
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

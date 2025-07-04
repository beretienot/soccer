package com.example.soccer.application.team;

import com.example.soccer.application.common.Command;
import com.example.soccer.domain.team.TeamId;

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

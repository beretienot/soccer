package com.example.soccer.player.application;

import com.example.soccer.player.domain.PlayerId;
import com.example.soccer.shared.application.Command;
import com.example.soccer.team.domain.TeamId;

public class CreatePlayerCommand implements Command<PlayerId> {
    private final PlayerId id;
    private final TeamId teamId;
    private final String name;

    public CreatePlayerCommand(PlayerId id, TeamId teamId, String name) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
    }

    public PlayerId getId() { return id; }
    public TeamId getTeamId() { return teamId; }
    public String getName() { return name; }
}

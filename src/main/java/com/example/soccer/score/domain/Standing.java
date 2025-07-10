package com.example.soccer.score.domain;

import com.example.soccer.team.domain.TeamId;

/**
 * Value object representing team points in standings.
 */
public class Standing {
    private final TeamId teamId;
    private final int points;

    public Standing(TeamId teamId, int points) {
        this.teamId = teamId;
        this.points = points;
    }

    public TeamId getTeamId() { return teamId; }
    public int getPoints() { return points; }
}

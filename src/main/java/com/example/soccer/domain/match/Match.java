package com.example.soccer.domain.match;

import com.example.soccer.domain.team.TeamId;
import java.time.LocalDate;

/**
 * Aggregate root representing a scheduled match.
 */
public class Match {
    private final MatchId id;
    private final TeamId homeTeam;
    private final TeamId awayTeam;
    private final LocalDate date;

    public Match(MatchId id, TeamId homeTeam, TeamId awayTeam, LocalDate date) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
    }

    public MatchId getId() { return id; }
    public TeamId getHomeTeam() { return homeTeam; }
    public TeamId getAwayTeam() { return awayTeam; }
    public LocalDate getDate() { return date; }
}

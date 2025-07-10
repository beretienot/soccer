package com.example.soccer.score.domain;

import com.example.soccer.player.domain.PlayerId;

/**
 * Value object representing a player's goal tally.
 */
public class ScoreEntry {
    private final PlayerId playerId;
    private final int goals;

    public ScoreEntry(PlayerId playerId, int goals) {
        this.playerId = playerId;
        this.goals = goals;
    }

    public PlayerId getPlayerId() { return playerId; }
    public int getGoals() { return goals; }
}

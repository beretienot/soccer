package com.example.soccer.player.domain;

import java.util.List;
import java.util.Optional;

import com.example.soccer.team.domain.TeamId;

public interface PlayerRepository {
    Optional<Player> findById(PlayerId id);
    List<Player> findByTeam(TeamId teamId);
    void save(Player player);
}

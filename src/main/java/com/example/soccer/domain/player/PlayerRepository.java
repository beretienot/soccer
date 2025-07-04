package com.example.soccer.domain.player;

import com.example.soccer.domain.team.TeamId;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    Optional<Player> findById(PlayerId id);
    List<Player> findByTeam(TeamId teamId);
    void save(Player player);
}

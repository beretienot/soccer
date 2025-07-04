package com.example.soccer.infrastructure.player;

import com.example.soccer.domain.player.Player;
import com.example.soccer.domain.player.PlayerId;
import com.example.soccer.domain.player.PlayerRepository;
import com.example.soccer.domain.team.TeamId;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPlayerRepository implements PlayerRepository {

    private final Map<PlayerId, Player> players = new HashMap<>();

    @Override
    public Optional<Player> findById(PlayerId id) {
        return Optional.ofNullable(players.get(id));
    }

    @Override
    public List<Player> findByTeam(TeamId teamId) {
        List<Player> result = new ArrayList<>();
        for (Player p : players.values()) {
            if (p.getTeamId().equals(teamId)) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void save(Player player) {
        players.put(player.getId(), player);
    }
}

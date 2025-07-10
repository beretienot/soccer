package com.example.soccer.player.infrastructure;

import com.example.soccer.player.domain.Player;
import com.example.soccer.player.domain.PlayerId;
import com.example.soccer.player.domain.PlayerRepository;
import com.example.soccer.team.domain.TeamId;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("inmemory")
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

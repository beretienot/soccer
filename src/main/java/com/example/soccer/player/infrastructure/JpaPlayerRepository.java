package com.example.soccer.player.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.soccer.player.domain.Player;
import com.example.soccer.player.domain.PlayerId;
import com.example.soccer.player.domain.PlayerRepository;
import com.example.soccer.team.domain.TeamId;

@Repository
public class JpaPlayerRepository implements PlayerRepository {

    private final PlayerJpaRepository jpaRepository;

    public JpaPlayerRepository(PlayerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Player> findById(PlayerId id) {
        return jpaRepository.findById(id.toString())
                .map(e -> new Player(new PlayerId(e.getId()), new TeamId(e.getTeamId()), e.getName()));
    }

    @Override
    public List<Player> findByTeam(TeamId teamId) {
        return jpaRepository.findAll().stream()
                .filter(e -> e.getTeamId().equals(teamId.toString()))
                .map(e -> new Player(new PlayerId(e.getId()), new TeamId(e.getTeamId()), e.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Player player) {
        jpaRepository.save(new PlayerEntity(
                player.getId().toString(),
                player.getTeamId().toString(),
                player.getName()));
    }
}

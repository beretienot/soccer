package com.example.soccer.team.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.soccer.team.domain.Team;
import com.example.soccer.team.domain.TeamId;
import com.example.soccer.team.domain.TeamRepository;

@Repository
public class JpaTeamRepository implements TeamRepository {

    private final TeamJpaRepository jpaRepository;

    public JpaTeamRepository(TeamJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Team> findById(TeamId id) {
        return jpaRepository.findById(id.toString())
                .map(e -> new Team(new TeamId(e.getId()), e.getName()));
    }

    @Override
    public List<Team> findAll() {
        return jpaRepository.findAll().stream()
                .map(e -> new Team(new TeamId(e.getId()), e.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Team team) {
        jpaRepository.save(new TeamEntity(team.getId().toString(), team.getName()));
    }
}

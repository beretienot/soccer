package com.example.soccer.infrastructure.team;

import com.example.soccer.domain.team.Team;
import com.example.soccer.domain.team.TeamId;
import com.example.soccer.domain.team.TeamRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTeamRepository implements TeamRepository {

    private final Map<TeamId, Team> teams = new HashMap<>();

    @Override
    public Optional<Team> findById(TeamId id) {
        return Optional.ofNullable(teams.get(id));
    }

    @Override
    public List<Team> findAll() {
        return new ArrayList<>(teams.values());
    }

    @Override
    public void save(Team team) {
        teams.put(team.getId(), team);
    }
}

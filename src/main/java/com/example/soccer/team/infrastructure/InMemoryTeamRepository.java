package com.example.soccer.team.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.soccer.team.domain.Team;
import com.example.soccer.team.domain.TeamId;
import com.example.soccer.team.domain.TeamRepository;

import java.util.*;

@Component
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

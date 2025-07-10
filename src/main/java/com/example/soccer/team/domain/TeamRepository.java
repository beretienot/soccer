package com.example.soccer.team.domain;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {
    Optional<Team> findById(TeamId id);
    List<Team> findAll();
    void save(Team team);
}

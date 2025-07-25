package com.example.soccer.match.domain;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {
    Optional<Match> findById(MatchId id);
    List<Match> findAll();
    void save(Match match);
}

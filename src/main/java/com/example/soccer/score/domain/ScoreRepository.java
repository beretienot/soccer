package com.example.soccer.score.domain;

import java.util.List;

public interface ScoreRepository {
    List<ScoreEntry> findTopScorers();
    void save(ScoreEntry entry);
}

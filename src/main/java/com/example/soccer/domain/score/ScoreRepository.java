package com.example.soccer.domain.score;

import java.util.List;

public interface ScoreRepository {
    List<ScoreEntry> findTopScorers();
    void save(ScoreEntry entry);
}

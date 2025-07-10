package com.example.soccer.score.infrastructure;

import com.example.soccer.player.domain.PlayerId;
import com.example.soccer.score.domain.ScoreEntry;
import com.example.soccer.score.domain.ScoreRepository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryScoreRepository implements ScoreRepository {

    private final Map<PlayerId, Integer> scores = new HashMap<>();

    @Override
    public List<ScoreEntry> findTopScorers() {
        List<ScoreEntry> entries = new ArrayList<>();
        for (Map.Entry<PlayerId, Integer> e : scores.entrySet()) {
            entries.add(new ScoreEntry(e.getKey(), e.getValue()));
        }
        entries.sort((a, b) -> Integer.compare(b.getGoals(), a.getGoals()));
        return entries;
    }

    @Override
    public void save(ScoreEntry entry) {
        scores.put(entry.getPlayerId(), entry.getGoals());
    }
}

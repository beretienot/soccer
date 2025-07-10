package com.example.soccer.score.application;

import com.example.soccer.score.domain.ScoreEntry;
import com.example.soccer.score.domain.ScoreRepository;
import com.example.soccer.shared.application.QueryHandler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTopScorersQueryHandler implements QueryHandler<GetTopScorersQuery, List<ScoreEntry>> {

    private final ScoreRepository repository;

    public GetTopScorersQueryHandler(ScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ScoreEntry> handle(GetTopScorersQuery query) {
        return repository.findTopScorers();
    }
}

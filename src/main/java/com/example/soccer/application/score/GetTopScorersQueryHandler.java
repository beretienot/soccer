package com.example.soccer.application.score;

import com.example.soccer.application.common.QueryHandler;
import com.example.soccer.domain.score.ScoreEntry;
import com.example.soccer.domain.score.ScoreRepository;
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

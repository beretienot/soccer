package com.example.soccer.application.score;

import com.example.soccer.application.common.QueryHandler;
import com.example.soccer.domain.score.Standing;
import com.example.soccer.domain.score.StandingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStandingsQueryHandler implements QueryHandler<GetStandingsQuery, List<Standing>> {

    private final StandingRepository repository;

    public GetStandingsQueryHandler(StandingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Standing> handle(GetStandingsQuery query) {
        return repository.findAll();
    }
}

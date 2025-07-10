package com.example.soccer.score.application;

import com.example.soccer.score.domain.Standing;
import com.example.soccer.score.domain.StandingRepository;
import com.example.soccer.shared.application.QueryHandler;

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

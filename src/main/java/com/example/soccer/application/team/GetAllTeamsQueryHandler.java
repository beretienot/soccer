package com.example.soccer.application.team;

import com.example.soccer.application.common.QueryHandler;
import com.example.soccer.domain.team.Team;
import com.example.soccer.domain.team.TeamRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllTeamsQueryHandler implements QueryHandler<GetAllTeamsQuery, List<String>> {

    private final TeamRepository repository;

    public GetAllTeamsQueryHandler(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> handle(GetAllTeamsQuery query) {
        return repository.findAll().stream().map(Team::getName).collect(Collectors.toList());
    }
}

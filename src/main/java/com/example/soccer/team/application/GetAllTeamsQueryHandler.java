package com.example.soccer.team.application;

import com.example.soccer.shared.application.QueryHandler;
import com.example.soccer.team.domain.Team;
import com.example.soccer.team.domain.TeamRepository;

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

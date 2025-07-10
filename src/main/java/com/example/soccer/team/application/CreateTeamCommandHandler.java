package com.example.soccer.team.application;

import com.example.soccer.shared.application.CommandHandler;
import com.example.soccer.team.domain.Team;
import com.example.soccer.team.domain.TeamCreatedEvent;
import com.example.soccer.team.domain.TeamId;
import com.example.soccer.team.domain.TeamRepository;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CreateTeamCommandHandler implements CommandHandler<CreateTeamCommand, TeamId> {

    private final TeamRepository repository;
    private final ApplicationEventPublisher events;

    public CreateTeamCommandHandler(TeamRepository repository, ApplicationEventPublisher events) {
        this.repository = repository;
        this.events = events;
    }

    @Override
    public TeamId handle(CreateTeamCommand command) {
        Team team = new Team(command.getId(), command.getName());
        repository.save(team);
        events.publishEvent(new TeamCreatedEvent(team));
        return team.getId();
    }
}

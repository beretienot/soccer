package com.example.soccer.application.team;

import com.example.soccer.application.common.CommandHandler;
import com.example.soccer.domain.team.Team;
import com.example.soccer.domain.team.TeamCreatedEvent;
import com.example.soccer.domain.team.TeamId;
import com.example.soccer.domain.team.TeamRepository;
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

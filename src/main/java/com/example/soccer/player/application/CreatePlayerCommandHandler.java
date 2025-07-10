package com.example.soccer.player.application;

import com.example.soccer.player.domain.Player;
import com.example.soccer.player.domain.PlayerCreatedEvent;
import com.example.soccer.player.domain.PlayerId;
import com.example.soccer.player.domain.PlayerRepository;
import com.example.soccer.shared.application.CommandHandler;
import com.example.soccer.team.domain.TeamId;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerCommandHandler implements CommandHandler<CreatePlayerCommand, PlayerId> {

    private final PlayerRepository repository;
    private final ApplicationEventPublisher events;

    public CreatePlayerCommandHandler(PlayerRepository repository, ApplicationEventPublisher events) {
        this.repository = repository;
        this.events = events;
    }

    @Override
    public PlayerId handle(CreatePlayerCommand command) {
        Player player = new Player(command.getId(), command.getTeamId(), command.getName());
        repository.save(player);
        events.publishEvent(new PlayerCreatedEvent(player));
        return player.getId();
    }
}

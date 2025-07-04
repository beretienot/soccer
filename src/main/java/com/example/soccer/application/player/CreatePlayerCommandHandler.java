package com.example.soccer.application.player;

import com.example.soccer.application.common.CommandHandler;
import com.example.soccer.domain.player.Player;
import com.example.soccer.domain.player.PlayerCreatedEvent;
import com.example.soccer.domain.player.PlayerId;
import com.example.soccer.domain.player.PlayerRepository;
import com.example.soccer.domain.team.TeamId;
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

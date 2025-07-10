package com.example.soccer.player.infrastructure;

import com.example.soccer.player.application.CreatePlayerCommand;
import com.example.soccer.player.domain.PlayerId;
import com.example.soccer.shared.application.CommandBus;
import com.example.soccer.team.domain.TeamId;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final CommandBus commandBus;

    public PlayerController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreatePlayerRequest request) {
        PlayerId id = commandBus.dispatch(
                new CreatePlayerCommand(
                        new PlayerId(request.id()),
                        new TeamId(request.teamId()),
                        request.name()));
        return ResponseEntity.ok(id.toString());
    }

    public record CreatePlayerRequest(String id, String teamId, String name) {}
}

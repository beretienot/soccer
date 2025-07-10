package com.example.soccer.team.infrastructure;

import com.example.soccer.shared.application.CommandBus;
import com.example.soccer.shared.application.QueryBus;
import com.example.soccer.team.application.CreateTeamCommand;
import com.example.soccer.team.application.GetAllTeamsQuery;
import com.example.soccer.team.domain.TeamId;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public TeamController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTeamRequest request) {
        TeamId id = commandBus.dispatch(new CreateTeamCommand(new TeamId(request.id()), request.name()));
        return ResponseEntity.ok(id.toString());
    }

    @GetMapping
    public ResponseEntity<List<String>> all() {
        return ResponseEntity.ok(queryBus.dispatch(new GetAllTeamsQuery()));
    }

    public record CreateTeamRequest(String id, String name) {}
}

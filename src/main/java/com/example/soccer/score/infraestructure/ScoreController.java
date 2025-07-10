package com.example.soccer.score.infraestructure;

import com.example.soccer.score.application.GetStandingsQuery;
import com.example.soccer.score.application.GetTopScorersQuery;
import com.example.soccer.score.domain.ScoreEntry;
import com.example.soccer.score.domain.Standing;
import com.example.soccer.shared.application.QueryBus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final QueryBus queryBus;

    public ScoreController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/standings")
    public ResponseEntity<List<Standing>> standings() {
        return ResponseEntity.ok(queryBus.dispatch(new GetStandingsQuery()));
    }

    @GetMapping("/top-scorers")
    public ResponseEntity<List<ScoreEntry>> topScorers() {
        return ResponseEntity.ok(queryBus.dispatch(new GetTopScorersQuery()));
    }
}

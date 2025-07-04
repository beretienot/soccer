package com.example.soccer.infrastructure.score;

import com.example.soccer.application.common.QueryBus;
import com.example.soccer.application.score.GetStandingsQuery;
import com.example.soccer.application.score.GetTopScorersQuery;
import com.example.soccer.domain.score.ScoreEntry;
import com.example.soccer.domain.score.Standing;
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

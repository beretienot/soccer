package com.example.soccer.score.infraestructure;

import com.example.soccer.score.domain.Standing;
import com.example.soccer.score.domain.StandingRepository;
import com.example.soccer.team.domain.TeamId;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryStandingRepository implements StandingRepository {

    private final Map<TeamId, Integer> standings = new HashMap<>();

    @Override
    public List<Standing> findAll() {
        List<Standing> list = new ArrayList<>();
        for (Map.Entry<TeamId, Integer> e : standings.entrySet()) {
            list.add(new Standing(e.getKey(), e.getValue()));
        }
        list.sort((a,b) -> Integer.compare(b.getPoints(), a.getPoints()));
        return list;
    }

    @Override
    public void save(Standing standing) {
        standings.put(standing.getTeamId(), standing.getPoints());
    }
}

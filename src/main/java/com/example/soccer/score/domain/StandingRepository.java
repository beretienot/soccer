package com.example.soccer.score.domain;

import java.util.List;

public interface StandingRepository {
    List<Standing> findAll();
    void save(Standing standing);
}

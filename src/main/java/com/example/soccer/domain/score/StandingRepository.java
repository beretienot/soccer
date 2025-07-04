package com.example.soccer.domain.score;

import java.util.List;

public interface StandingRepository {
    List<Standing> findAll();
    void save(Standing standing);
}

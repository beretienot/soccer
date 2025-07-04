package com.example.soccer.domain.match;

import java.util.Objects;

public record MatchId(String value) {
    public MatchId {
        Objects.requireNonNull(value, "id must not be null");
    }

    @Override
    public String toString() {
        return value;
    }
}

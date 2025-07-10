package com.example.soccer.team.domain;

import java.util.Objects;

public record TeamId(String value) {
    public TeamId {
        Objects.requireNonNull(value, "id must not be null");
    }

    @Override
    public String toString() {
        return value;
    }
}

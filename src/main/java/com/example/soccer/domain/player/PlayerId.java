package com.example.soccer.domain.player;

import java.util.Objects;

public record PlayerId(String value) {
    public PlayerId {
        Objects.requireNonNull(value, "id must not be null");
    }

    @Override
    public String toString() {
        return value;
    }
}

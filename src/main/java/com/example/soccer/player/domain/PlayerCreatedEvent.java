package com.example.soccer.player.domain;

public class PlayerCreatedEvent {
    private final Player player;

    public PlayerCreatedEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}

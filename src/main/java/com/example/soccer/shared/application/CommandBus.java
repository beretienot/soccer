package com.example.soccer.shared.application;

public interface CommandBus {
    <R, C extends Command<R>> R dispatch(C command);
}

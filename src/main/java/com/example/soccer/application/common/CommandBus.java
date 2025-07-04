package com.example.soccer.application.common;

public interface CommandBus {
    <R, C extends Command<R>> R dispatch(C command);
}

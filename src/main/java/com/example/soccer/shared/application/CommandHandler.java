package com.example.soccer.shared.application;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}

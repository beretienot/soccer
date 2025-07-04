package com.example.soccer.application.common;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}

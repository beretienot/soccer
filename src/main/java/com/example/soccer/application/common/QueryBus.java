package com.example.soccer.application.common;

public interface QueryBus {
    <R, Q extends Query<R>> R dispatch(Q query);
}

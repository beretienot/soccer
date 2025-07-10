package com.example.soccer.shared.application;

public interface QueryBus {
    <R, Q extends Query<R>> R dispatch(Q query);
}

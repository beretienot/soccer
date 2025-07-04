package com.example.soccer.infrastructure.common;

import com.example.soccer.application.common.Query;
import com.example.soccer.application.common.QueryBus;
import com.example.soccer.application.common.QueryHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueryBus implements QueryBus {

    private final ApplicationContext context;

    public SimpleQueryBus(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public <R, Q extends Query<R>> R dispatch(Q query) {
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) context.getBean(query.getClass().getSimpleName() + "Handler");
        return handler.handle(query);
    }
}

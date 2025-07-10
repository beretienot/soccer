package com.example.soccer.shared.infrastructure;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.soccer.shared.application.Query;
import com.example.soccer.shared.application.QueryBus;
import com.example.soccer.shared.application.QueryHandler;

@Component
public class SimpleQueryBus implements QueryBus {

    private final ApplicationContext context;

    public SimpleQueryBus(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public <R, Q extends Query<R>> R dispatch(Q query) {
        String handlerBeanName = Character.toLowerCase(query.getClass().getSimpleName().charAt(0))
                + query.getClass().getSimpleName().substring(1) + "Handler";
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) context.getBean(handlerBeanName);
        return handler.handle(query);
    }
}

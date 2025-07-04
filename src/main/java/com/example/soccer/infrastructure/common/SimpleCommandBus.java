package com.example.soccer.infrastructure.common;

import com.example.soccer.application.common.Command;
import com.example.soccer.application.common.CommandBus;
import com.example.soccer.application.common.CommandHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SimpleCommandBus implements CommandBus {

    private final ApplicationContext context;

    public SimpleCommandBus(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public <R, C extends Command<R>> R dispatch(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) context.getBean(command.getClass().getSimpleName() + "Handler");
        return handler.handle(command);
    }
}

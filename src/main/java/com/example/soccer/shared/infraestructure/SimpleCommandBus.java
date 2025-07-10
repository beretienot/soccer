package com.example.soccer.shared.infraestructure;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.soccer.shared.application.Command;
import com.example.soccer.shared.application.CommandBus;
import com.example.soccer.shared.application.CommandHandler;

@Component
public class SimpleCommandBus implements CommandBus {

    private final ApplicationContext context;

    public SimpleCommandBus(ApplicationContext context) {
        this.context = context;
    }

  @Override
    public <R, C extends Command<R>> R dispatch(C command) {
        String handlerBeanName = Character.toLowerCase(command.getClass().getSimpleName().charAt(0))
                + command.getClass().getSimpleName().substring(1) + "Handler";
        CommandHandler<C, R> handler = (CommandHandler<C, R>) context.getBean(handlerBeanName);
        return handler.handle(command);
    }
}

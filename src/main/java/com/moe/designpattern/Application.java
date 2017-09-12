package com.moe.designpattern;

import com.moe.designpattern.event.ApplicationEvent;
import com.moe.designpattern.event.EnvironmentCreateEvent;
import com.moe.designpattern.event.EnvironmentUpdateEvent;
import com.moe.designpattern.event.EventType;
import com.moe.designpattern.handler.ApplicationEventHandler;
import com.moe.designpattern.listener.EnvironmentCreateEventListener;
import com.moe.designpattern.listener.EnvironmentUpdateEventListener;
import com.moe.designpattern.model.Environment;

public class Application {

    public static void main(String[] args) {
        Environment environment = new Environment("dev", "development");
        ApplicationEventHandler.register(EventType.ENVIRONMENT_CREATE,
                new EnvironmentCreateEventListener());

        ApplicationEventHandler.register(EventType.ENVIRONMENT_UPDATE,
                new EnvironmentUpdateEventListener());

        ApplicationEventHandler.publish(new EnvironmentCreateEvent(environment));

        updateEnvironment(environment);
    }

    /**
     * Update Environment
     * @param environment
     */
    private static void updateEnvironment(Environment environment) {
        environment.setLocation("production");
    }
}

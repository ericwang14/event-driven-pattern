package com.moe.designpattern.listener;

import com.moe.designpattern.event.EnvironmentCreateEvent;
import com.moe.designpattern.event.EventType;

import java.util.logging.Logger;

public final class EnvironmentCreateEventListener implements ApplicationEventListener<EnvironmentCreateEvent> {

    private final static Logger _LOGGER = Logger.getLogger(EnvironmentCreateEventListener.class.getName());

    private EnvironmentCreateEvent applicationEvent;

    public void onApplicationEvent(EnvironmentCreateEvent applicationEvent) {
        _LOGGER.info("Environment create event listener triggered! " + applicationEvent);
        this.applicationEvent = applicationEvent;
    }

    public EnvironmentCreateEvent getEvent() {
        return applicationEvent;
    }

    public boolean acceptable(EventType eventType) {
        return EventType.ENVIRONMENT_CREATE.equals(eventType);
    }
}

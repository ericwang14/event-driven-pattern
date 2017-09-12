package com.moe.designpattern.listener;

import com.moe.designpattern.event.EnvironmentUpdateEvent;
import com.moe.designpattern.event.EventType;

import java.util.logging.Logger;

public final class EnvironmentUpdateEventListener implements ApplicationEventListener<EnvironmentUpdateEvent> {

    private final static Logger _LOGGER = Logger.getLogger(EnvironmentUpdateEventListener.class.getName());


    private EnvironmentUpdateEvent applicationEvent;

    public void onApplicationEvent(EnvironmentUpdateEvent applicationEvent) {
        _LOGGER.info("Environment create event listener triggered! " + applicationEvent);
        this.applicationEvent = applicationEvent;
    }

    public EnvironmentUpdateEvent getEvent() {
        return applicationEvent;
    }

    public boolean acceptable(EventType eventType) {
        return EventType.ENVIRONMENT_UPDATE.equals(eventType);
    }
}

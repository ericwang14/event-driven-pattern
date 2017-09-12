package com.moe.designpattern.listener;

import com.moe.designpattern.event.EnvironmentCreateEvent;
import com.moe.designpattern.event.EventType;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * Environment create event listener
 *
 * @author ericw
 * @since 9/11/17
 */
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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof EnvironmentCreateEventListener)) {
            return false;
        }

        EnvironmentCreateEventListener obj = (EnvironmentCreateEventListener) o;

        return this.getEvent().equals(obj.getEvent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEvent());
    }
}

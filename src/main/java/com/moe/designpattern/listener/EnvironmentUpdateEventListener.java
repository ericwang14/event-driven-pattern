package com.moe.designpattern.listener;

import com.moe.designpattern.event.EnvironmentUpdateEvent;
import com.moe.designpattern.event.EventType;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * Environment update event listener
 *
 * @author ericw
 * @since 9/11/17
 */
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


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof EnvironmentUpdateEventListener)) {
            return false;
        }

        EnvironmentUpdateEventListener obj = (EnvironmentUpdateEventListener) o;

        return this.getEvent().equals(obj.getEvent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEvent());
    }
}

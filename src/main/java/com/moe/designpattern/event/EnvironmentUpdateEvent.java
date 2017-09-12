package com.moe.designpattern.event;

import com.moe.designpattern.model.Environment;

import java.util.Objects;

/**
 * Environment Update Event
 *
 * @author ericw
 * @since 9/11/17
 */
public final class EnvironmentUpdateEvent implements ApplicationEvent {

    private final Environment environment;

    public EnvironmentUpdateEvent(Environment environment) {
        this.environment = environment;
    }

    public EventType getType() {
        return EventType.ENVIRONMENT_UPDATE;
    }

    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof EnvironmentUpdateEvent)) {
            return false;
        }

        EnvironmentUpdateEvent obj = (EnvironmentUpdateEvent) o;

        return this.getType().equals(obj.getType()) &&
                this.getEnvironment().equals(obj.getEnvironment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getEnvironment());
    }

    @Override
    public String toString() {
        return "Event " + getType().name() + " for " + environment;
    }
}

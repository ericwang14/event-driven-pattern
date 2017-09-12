package com.moe.designpattern.event;

import com.moe.designpattern.model.Environment;

import java.util.Objects;

/**
 * Environment Create event
 *
 * @author ericw
 * @since 9/11/17
 */
public class EnvironmentCreateEvent implements ApplicationEvent {

    private final Environment environment;

    public EnvironmentCreateEvent(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public EventType getType() {
        return EventType.ENVIRONMENT_CREATE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof EnvironmentCreateEvent)) {
            return false;
        }

        EnvironmentCreateEvent obj = (EnvironmentCreateEvent) o;

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

package com.moe.designpattern.model;

import com.moe.designpattern.event.EnvironmentUpdateEvent;
import com.moe.designpattern.handler.ApplicationEventHandler;

public class Environment {

    private String location;
    private String profile;

    public Environment(String location, String profile) {
        this.location = location;
        this.profile = profile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        ApplicationEventHandler.publish(new EnvironmentUpdateEvent(this));
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
        ApplicationEventHandler.publish(new EnvironmentUpdateEvent(this));
    }

    @Override
    public String toString() {
        return "Environment " + this.location + " for " + this.profile;
    }
}

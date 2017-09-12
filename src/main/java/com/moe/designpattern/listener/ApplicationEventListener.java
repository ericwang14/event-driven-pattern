package com.moe.designpattern.listener;

import com.moe.designpattern.event.ApplicationEvent;
import com.moe.designpattern.event.EventType;

public interface ApplicationEventListener<E extends ApplicationEvent> {

    void onApplicationEvent(E applicationEvent);

    E getEvent();

    boolean acceptable(EventType eventType);
}

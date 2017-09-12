package com.moe.designpattern.listener;

import com.moe.designpattern.event.ApplicationEvent;
import com.moe.designpattern.event.EventType;

/**
 * Application Event Listener interface
 * all the event listener needs implement this interface
 * the implementation listener will be used to register event listener.
 * for event please refer to {@link ApplicationEvent}
 *
 * @auther ericw
 * @since 9/11/17
 */
public interface ApplicationEventListener<E extends ApplicationEvent> {

    void onApplicationEvent(E applicationEvent);

    E getEvent();

    boolean acceptable(EventType eventType);
}

package com.moe.designpattern.event;

import com.moe.designpattern.listener.ApplicationEventListener;

/**
 * Application Event interface
 * all the event needs implement this interface
 * the implementation event will be used to register event.
 *
 * for listener please refer to {@link ApplicationEventListener}
 *
 * @auther ericw
 * @since 9/11/17
 */
public interface ApplicationEvent {

    /**
     * Get Event Type
     * @return event type
     */
    EventType getType();
}

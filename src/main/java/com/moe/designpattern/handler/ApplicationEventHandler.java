package com.moe.designpattern.handler;

import com.moe.designpattern.event.ApplicationEvent;
import com.moe.designpattern.event.EventType;
import com.moe.designpattern.listener.ApplicationEventListener;

import java.util.*;
import java.util.logging.Logger;

/**
 * Application events handler
 * this class used to register/deregister {@link ApplicationEventListener} to {@link ApplicationEvent}
 * one event can have multiple registered listeners.
 * for the listener and event please refer to {@link ApplicationEventListener} and {@link ApplicationEvent}
 *
 * the {@link #publish(ApplicationEvent)} method used to trigger the event,
 * all the registered listeners for that event will be getting triggered.
 *
 * @author ericw
 * @since 9/11/17
 */
public final class ApplicationEventHandler {

    private final static Logger _LOGGER = Logger.getLogger(ApplicationEventHandler.class.getName());
    private final static Map<EventType, List<ApplicationEventListener<ApplicationEvent>>> LISTENERS = new HashMap<>();

    private ApplicationEventHandler() {
        throw new IllegalStateException("ApplicationEventHandler no need instance");
    }

    public static Map<EventType, List<ApplicationEventListener<ApplicationEvent>>> getListeners() {
        return Collections.unmodifiableMap(LISTENERS);
    }
    /**
     * Register listener to event
     * if the listener not acceptable by event, throw out {@link IllegalArgumentException}
     * @param event     - event type
     * @param listener  - event listener
     */
    public static void register(EventType event, ApplicationEventListener listener) {
        if (!listener.acceptable(event)) {
            throw new IllegalArgumentException("Event " + event.name() + " not compatible with given listener!");
        }

        LISTENERS.computeIfAbsent(event, k -> new ArrayList<>());

        List<ApplicationEventListener<ApplicationEvent>> list = LISTENERS.get(event);
        list.add(listener);
        _LOGGER.info("add listener " + listener + " to event " + event);
    }

    /**
     * de-register event
     * @param eventType - event type
     */
    public static void deRegister(EventType eventType) {
        if (!LISTENERS.containsKey(eventType)) {
            return;
        }
        LISTENERS.remove(eventType);

        _LOGGER.info("remove event " + eventType);
    }

    /**
     * Publish event, trigger all registered listeners
     * if not found any listeners do nothing.
     * @param event - event type
     */
    public static void publish(final ApplicationEvent event) {
        List<ApplicationEventListener<ApplicationEvent>> listeners = LISTENERS.get(event.getType());

        if (listeners == null || listeners.size() <= 0) {
            return;
        }

        _LOGGER.info("trigger listeners for event " + event);
        listeners.forEach((listener) -> listener.onApplicationEvent(event));
    }
}

package com.moe.designpattern.handler;

import com.moe.designpattern.event.ApplicationEvent;
import com.moe.designpattern.event.EventType;
import com.moe.designpattern.listener.ApplicationEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class ApplicationEventHandler {

    private final static Logger _LOGGER = Logger.getLogger(ApplicationEventHandler.class.getName());
    private final static HashMap<EventType, List<ApplicationEventListener<ApplicationEvent>>> LISTENERS = new HashMap<>();

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
     * Remove listener
     * @param listener
     */
    public static void deRegister(ApplicationEventListener listener) {
        List<ApplicationEventListener<ApplicationEvent>> list = LISTENERS.get(listener.getEvent().getType());
        list.remove(listener);


        _LOGGER.info("remove listener " + listener);
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

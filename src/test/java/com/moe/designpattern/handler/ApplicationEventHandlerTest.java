package com.moe.designpattern.handler;

import com.moe.designpattern.event.ApplicationEvent;
import com.moe.designpattern.event.EnvironmentCreateEvent;
import com.moe.designpattern.event.EventType;
import com.moe.designpattern.listener.EnvironmentCreateEventListener;
import com.moe.designpattern.listener.EnvironmentUpdateEventListener;
import com.moe.designpattern.model.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ApplicationEventHandlerTest {
    private Environment environment;

    @Before
    public  void setup() {
        environment = new Environment("dev", "development");
    }

    @After
    public void tearDown() {
        environment = null;
    }

    @Test
    public void testRegister() {
        EnvironmentCreateEventListener createEventListener = new EnvironmentCreateEventListener();
        ApplicationEventHandler.register(EventType.ENVIRONMENT_CREATE, createEventListener);

        ApplicationEventHandler.register(EventType.ENVIRONMENT_UPDATE,
                new EnvironmentUpdateEventListener());

        ApplicationEventHandler.publish(new EnvironmentCreateEvent(environment));


        assertEquals(2, ApplicationEventHandler.getListeners().size());

        assertNotEquals(createEventListener, ApplicationEventHandler.getListeners().get(EventType.ENVIRONMENT_CREATE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRegisterFailed() {
        ApplicationEventHandler.register(EventType.ENVIRONMENT_UPDATE,
                new EnvironmentCreateEventListener());
    }

    @Test
    public void testDeRegister() {
        ApplicationEventHandler.register(EventType.ENVIRONMENT_CREATE,
                new EnvironmentCreateEventListener());

        ApplicationEventHandler.deRegister(EventType.ENVIRONMENT_CREATE);

        ApplicationEventHandler.publish(new EnvironmentCreateEvent(environment));

        assertEquals(0, ApplicationEventHandler.getListeners().size());
    }
}

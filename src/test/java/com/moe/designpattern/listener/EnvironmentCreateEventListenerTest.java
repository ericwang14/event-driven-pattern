package com.moe.designpattern.listener;

import com.moe.designpattern.event.EnvironmentCreateEvent;
import com.moe.designpattern.event.EventType;
import com.moe.designpattern.model.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EnvironmentCreateEventListenerTest {

    private EnvironmentCreateEvent event;

    @Before
    public void setup() {
        this.event = new EnvironmentCreateEvent(new Environment("test", "test"));
    }

    @After
    public  void tearDown() {
        this.event = null;
    }

    @Test
    public void testOnApplicationEvent() {
        EnvironmentCreateEventListener listener = new EnvironmentCreateEventListener();
        listener.onApplicationEvent(event);

        assertEquals(event, listener.getEvent());
        assertEquals("test", listener.getEvent().getEnvironment().getLocation());


        EnvironmentCreateEventListener listener2 = new EnvironmentCreateEventListener();

        listener2.onApplicationEvent(event);
        assertEquals(listener, listener2);

        EnvironmentCreateEventListener listener3 = new EnvironmentCreateEventListener();

        assertNotEquals(listener, listener3);
    }

    @Test
    public void testAcceptable() {
        EnvironmentCreateEventListener listener = new EnvironmentCreateEventListener();
        assertTrue(listener.acceptable(EventType.ENVIRONMENT_CREATE));
        assertFalse(listener.acceptable(EventType.ENVIRONMENT_UPDATE));
    }
}

package com.moe.designpattern.listener;

import com.moe.designpattern.event.EnvironmentUpdateEvent;
import com.moe.designpattern.event.EventType;
import com.moe.designpattern.model.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EnvironmentUpdateEventListenerTest {


    private EnvironmentUpdateEvent event;

    @Before
    public void setup() {
        this.event = new EnvironmentUpdateEvent(new Environment("test", "test"));
    }

    @After
    public  void tearDown() {
        this.event = null;
    }

    @Test
    public void testOnApplicationEvent() {
        EnvironmentUpdateEventListener listener = new EnvironmentUpdateEventListener();
        listener.onApplicationEvent(event);

        assertEquals(event, listener.getEvent());
        assertEquals("test", listener.getEvent().getEnvironment().getLocation());


        EnvironmentUpdateEventListener listener2 = new EnvironmentUpdateEventListener();

        listener2.onApplicationEvent(event);
        assertEquals(listener, listener2);

        EnvironmentUpdateEventListener listener3 = new EnvironmentUpdateEventListener();

        assertNotEquals(listener, listener3);
    }

    @Test
    public void testAcceptable() {
        EnvironmentUpdateEventListener listener = new EnvironmentUpdateEventListener();
        assertTrue(listener.acceptable(EventType.ENVIRONMENT_UPDATE));
        assertFalse(listener.acceptable(EventType.ENVIRONMENT_CREATE));
    }
}

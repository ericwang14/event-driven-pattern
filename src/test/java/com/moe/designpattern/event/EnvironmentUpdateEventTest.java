package com.moe.designpattern.event;

import com.moe.designpattern.model.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class EnvironmentUpdateEventTest {


    private Environment environment;

    @Before
    public void setup() {
        environment = new Environment("test", "test");
    }

    @After
    public void tearDown() {
        environment = null;
    }
    @Test
    public void testCreate() {
        EnvironmentUpdateEvent event = new EnvironmentUpdateEvent(environment);

        assertNotNull(event);

        assertEquals("test", event.getEnvironment().getLocation());

        EnvironmentUpdateEvent event1 = new EnvironmentUpdateEvent(environment);
        EnvironmentUpdateEvent event2 = new EnvironmentUpdateEvent(new Environment("test1", "test"));

        assertEquals(event, event1);
        assertEquals(event1, event);
        assertNotEquals(event2, event);

        assertEquals(EventType.ENVIRONMENT_UPDATE, event.getType());
    }
}

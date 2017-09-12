package com.moe.designpattern.event;

import com.moe.designpattern.model.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class EnvironmentCreateEventTest {

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
        EnvironmentCreateEvent event = new EnvironmentCreateEvent(environment);

        assertNotNull(event);

        assertEquals("test", event.getEnvironment().getLocation());

        EnvironmentCreateEvent event1 = new EnvironmentCreateEvent(environment);
        EnvironmentCreateEvent event2 = new EnvironmentCreateEvent(new Environment("test1", "test"));

        assertEquals(event, event1);
        assertEquals(event1, event);
        assertNotEquals(event2, event);

        assertEquals(EventType.ENVIRONMENT_CREATE, event.getType());
    }
}

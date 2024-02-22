package com.travelers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {
    @Test
    public void testGetters() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Activity Description", 50.0, 20, destination);

        assertEquals("Test Activity", activity.getName());
        assertEquals("Activity Description", activity.getDescription());
        assertEquals(50.0, activity.getCost(), 0.01);
        assertEquals(20, activity.getCapacity());
        assertEquals(destination, activity.getDestination());
    }
    @Test
    public void testSetters() {
        Destination destination1 = new Destination("Destination 1");
        Destination destination2 = new Destination("Destination 2");
        Activity activity = new Activity("Test Activity", "Activity Description", 50.0, 20, destination1);

        activity.setCapacity(15);
        assertEquals(15, activity.getCapacity());

        activity.setDestination(destination2);
        assertEquals(destination2, activity.getDestination());
    }
}

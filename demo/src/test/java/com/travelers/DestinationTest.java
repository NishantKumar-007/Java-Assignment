package com.travelers;

import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationTest {

    @Test
    public void testDestinationInitialization() {
        Destination destination = new Destination("Paris");

        assertEquals("Paris", destination.getName());
        assertNotNull(destination.getActivities());
        assertTrue(destination.getActivities().isEmpty());
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Rome");
        Activity activity = new Activity("Colosseum Tour", "Historical tour of Colosseum", 60.0, 10, destination);

        assertTrue(destination.getActivities().isEmpty());

        destination.addActivity(activity);

        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void testAddActivityAlreadyAssociated() {
        Destination destination1 = new Destination("Berlin");
        Destination destination2 = new Destination("Munich");
    
        Activity activity = new Activity("Brandenburg Gate Tour", "Historical tour of Brandenburg Gate", 40.0, 15, destination1);
    
        assertEquals(0, destination2.getActivities().size());
    
        destination1.addActivity(activity);
    
        // Attempt to add the same activity to destination2
        destination2.addActivity(activity);
    
        assertEquals(0, destination2.getActivities().size());

    }

    @Test
    public void testDecrementCapacity() {
        Destination destination = new Destination("Amsterdam");
        Activity activity = new Activity("Van Gogh Museum Visit", "Art tour at Van Gogh Museum", 30.0, 12, destination);

        assertEquals(12, activity.getCapacity());

        destination.decrementCapacity(activity);

        assertEquals(11, activity.getCapacity());
    }
}

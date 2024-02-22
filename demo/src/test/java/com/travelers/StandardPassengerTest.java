package com.travelers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StandardPassengerTest {

    @Test
    public void testStandardPassengerInitialization() {
        StandardPassenger standardPassenger = new StandardPassenger("John Doe", 1, 100.0);

        assertEquals("John Doe", standardPassenger.getName());
        assertEquals(1, standardPassenger.getPassengerNumber());
        assertEquals(100.0, standardPassenger.getBalance(), 0.01); // Using delta for double comparison
        assertNotNull(standardPassenger.getSignedUpActivities());
        assertEquals(0, standardPassenger.getSignedUpActivities().size());
    }

    @Test
    public void testSignUpForActivityWithSufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Jane Doe", 2, 150.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Eiffel Tower Tour", "Guided tour of Eiffel Tower", 50.0, 15, destination);

        assertEquals(150.0, standardPassenger.getBalance(), 0.01);
        assertEquals(0, standardPassenger.getSignedUpActivities().size());

        standardPassenger.signUpForActivity(activity);

        assertEquals(100.0, standardPassenger.getBalance(), 0.01);
        assertEquals(1, standardPassenger.getSignedUpActivities().size());
        assertEquals(activity, standardPassenger.getSignedUpActivities().get(0));
    }

    @Test
    public void testSignUpForActivityWithInsufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Bob Smith", 3, 30.0);
        Destination destination = new Destination("Rome");
        Activity activity = new Activity("Colosseum Tour", "Historical tour of Colosseum", 60.0, 10, destination);

        assertEquals(30.0, standardPassenger.getBalance(), 0.01);
        assertEquals(0, standardPassenger.getSignedUpActivities().size());

        standardPassenger.signUpForActivity(activity);

        assertEquals(30.0, standardPassenger.getBalance(), 0.01);
        assertEquals(0, standardPassenger.getSignedUpActivities().size());
    }
}

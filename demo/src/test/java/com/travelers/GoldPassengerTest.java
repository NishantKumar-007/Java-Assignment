package com.travelers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoldPassengerTest {

    @Test
    public void testGoldPassengerInitialization() {
        GoldPassenger goldPassenger = new GoldPassenger("John Doe", 1, 100.0);

        assertEquals("John Doe", goldPassenger.getName());
        assertEquals(1, goldPassenger.getPassengerNumber());
        assertEquals(100.0, goldPassenger.getBalance(), 0.01); // Using delta for double comparison
        assertNotNull(goldPassenger.getSignedUpActivities());
        assertEquals(0, goldPassenger.getSignedUpActivities().size());
    }

    @Test
    public void testSignUpForActivity() {
        GoldPassenger goldPassenger = new GoldPassenger("Jane Doe", 2, 150.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Eiffel Tower Tour", "Guided tour of Eiffel Tower", 50.0, 15, destination);

        assertEquals(150.0, goldPassenger.getBalance(), 0.01);
        assertEquals(0, goldPassenger.getSignedUpActivities().size());

        goldPassenger.signUpForActivity(activity);

        assertEquals(105.0, goldPassenger.getBalance(), 0.01);
        assertEquals(1, goldPassenger.getSignedUpActivities().size());
        assertEquals(activity, goldPassenger.getSignedUpActivities().get(0));
    }

    @Test
    public void testSignUpForActivityWithInsufficientBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Bob Smith", 3, 50.0);
        Destination destination = new Destination("Rome");
        Activity activity = new Activity("Colosseum Tour", "Historical tour of Colosseum", 60.0, 10, destination);

        assertEquals(50.0, goldPassenger.getBalance(), 0.01);
        assertEquals(0, goldPassenger.getSignedUpActivities().size());

        goldPassenger.signUpForActivity(activity);

        assertEquals(50.0, goldPassenger.getBalance(), 0.01);
        assertEquals(0, goldPassenger.getSignedUpActivities().size());
    }
}

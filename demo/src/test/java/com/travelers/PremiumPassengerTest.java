package com.travelers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PremiumPassengerTest {

    @Test
    public void testPremiumPassengerInitialization() {
        PremiumPassenger premiumPassenger = new PremiumPassenger("Alice Smith", 1);

        assertEquals("Alice Smith", premiumPassenger.getName());
        assertEquals(1, premiumPassenger.getPassengerNumber());
        assertEquals(0.0, premiumPassenger.getBalance(), 0.01); // Using delta for double comparison
        assertNotNull(premiumPassenger.getSignedUpActivities());
        assertEquals(0, premiumPassenger.getSignedUpActivities().size());
    }

    @Test
    public void testSignUpForActivity() {
        PremiumPassenger premiumPassenger = new PremiumPassenger("Bob Johnson", 2);
        Destination destination = new Destination("Rome");
        Activity activity = new Activity("Colosseum Tour", "Historical tour of Colosseum", 60.0, 10, destination);

        assertEquals(0.0, premiumPassenger.getBalance(), 0.01);
        assertEquals(0, premiumPassenger.getSignedUpActivities().size());

        premiumPassenger.signUpForActivity(activity);

        assertEquals(0.0, premiumPassenger.getBalance(), 0.01);
        assertEquals(1, premiumPassenger.getSignedUpActivities().size());
        assertEquals(activity, premiumPassenger.getSignedUpActivities().get(0));
    }
}

package com.travelers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {

    private Passenger standardPassenger;
    private Passenger goldPassenger;
    private Passenger premiumPassenger;
    private Activity activityWithCapacity;
    private Activity activityWithoutCapacity;

    @Before
    public void setUp() {
        standardPassenger = new StandardPassenger("John", 1, 100.0);
        goldPassenger = new GoldPassenger("Alice", 2, 150.0);
        premiumPassenger = new PremiumPassenger("Bob", 3);

        Destination destination = new Destination("Paris");
        activityWithCapacity = new Activity("Eiffel Tower Tour", "Guided tour of Eiffel Tower", 100.0, 3, destination);
        activityWithoutCapacity = new Activity("Louvre Museum Visit", "Explore world-class art collections", 50.0, 0, destination);
    }

    @Test
    public void testGetName() {
        assertEquals("John", standardPassenger.getName());
        assertEquals("Alice", goldPassenger.getName());
        assertEquals("Bob", premiumPassenger.getName());
    }

    @Test
    public void testGetPassengerNumber() {
        assertEquals(1, standardPassenger.getPassengerNumber());
        assertEquals(2, goldPassenger.getPassengerNumber());
        assertEquals(3, premiumPassenger.getPassengerNumber());
    }

    @Test
    public void testGetBalance() {
        assertEquals(100.0, standardPassenger.getBalance(), 0.01);
        assertEquals(150.0, goldPassenger.getBalance(), 0.01);
        assertEquals(0.0, premiumPassenger.getBalance(), 0.01);
    }

    @Test
    public void testGetSignedUpActivities() {
        assertTrue(standardPassenger.getSignedUpActivities().isEmpty());
        assertTrue(goldPassenger.getSignedUpActivities().isEmpty());
        assertTrue(premiumPassenger.getSignedUpActivities().isEmpty());
    }

    @Test
    public void testSignUpForActivitySuccess() {
        standardPassenger.signUpForActivity(activityWithCapacity);
        goldPassenger.signUpForActivity(activityWithCapacity);
        premiumPassenger.signUpForActivity(activityWithCapacity);

        assertEquals(1, standardPassenger.getSignedUpActivities().size());
        assertEquals(1, goldPassenger.getSignedUpActivities().size());
        assertEquals(1, premiumPassenger.getSignedUpActivities().size());
        assertEquals(1, activityWithCapacity.getCapacity());
    }

    @Test
    public void testSignUpForActivityInsufficientBalance() {
        standardPassenger.signUpForActivity(activityWithCapacity);
        goldPassenger.signUpForActivity(activityWithoutCapacity);

        assertEquals(1, standardPassenger.getSignedUpActivities().size());
        assertTrue(goldPassenger.getSignedUpActivities().isEmpty());
        assertEquals(2, activityWithCapacity.getCapacity());
        assertEquals(0, activityWithoutCapacity.getCapacity());
    }

    @Test
    public void testSignUpForActivityFullCapacity() {
        standardPassenger.signUpForActivity(activityWithoutCapacity);

        assertTrue(standardPassenger.getSignedUpActivities().isEmpty());
        assertEquals(0, activityWithoutCapacity.getCapacity());
    }
}

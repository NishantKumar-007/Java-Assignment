package com.travelers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TravelPackageTest {

    @Mock
    private Destination mockDestination;

    @Mock
    private Passenger mockPassenger;

    @Mock
    private Activity mockActivity;

    private TravelPackage travelPackage;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        travelPackage = new TravelPackage("Test Package", 10);
    }

    @Test
    public void testAddDestination() {
        travelPackage.addDestination(mockDestination);
        assertEquals(1, travelPackage.getDestinations().size());
        assertEquals(mockDestination, travelPackage.getDestinations().get(0));
    }

    @Test
    public void testAddPassenger() {
        travelPackage.addPassenger(mockPassenger);
        assertEquals(1, travelPackage.getPassengers().size());
        assertEquals(mockPassenger, travelPackage.getPassengers().get(0));
    }

    @Test
    public void testPrintItinerary() {
        when(mockDestination.getName()).thenReturn("Paris");
        when(mockActivity.getName()).thenReturn("Eiffel Tower Tour");
        when(mockActivity.getDescription()).thenReturn("Guided tour of Eiffel Tower");
        when(mockActivity.getCost()).thenReturn(330.0);
        when(mockActivity.getCapacity()).thenReturn(15);
        when(mockDestination.getActivities()).thenReturn(Arrays.asList(mockActivity));
        travelPackage.addDestination(mockDestination);

        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printItinerary();

        // Assert expected output with platform-independent newline
    String expectedOutput = "Travel Package: Test Package" + System.lineSeparator() +
    "Destination: Paris" + System.lineSeparator() +
    "  Activity: Eiffel Tower Tour" + System.lineSeparator() +
    "    Description: Guided tour of Eiffel Tower" + System.lineSeparator() +
    "    Cost: $330.0" + System.lineSeparator() +
    "    Capacity: 15" + System.lineSeparator();

assertEquals(expectedOutput, outContent.toString());

        // Restore system output
        System.setOut(System.out);
    }

    @Test
    public void testPrintPassengerList() {
        when(mockPassenger.getName()).thenReturn("John Doe");
        when(mockPassenger.getPassengerNumber()).thenReturn(123);
        travelPackage.addPassenger(mockPassenger);

        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printPassengerList();

        // Assert expected output
        String expectedOutput = "Passenger List for Travel Package: Test Package" + System.lineSeparator()+
                "Capacity: 10" + System.lineSeparator()+
                "Number of Passengers Enrolled: 1" + System.lineSeparator()+
                "  Passenger: John Doe (#123)" +System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());

        // Restore system output
        System.setOut(System.out);
    }

    @Test
    public void testPrintPassengerDetails() {
        when(mockPassenger.getName()).thenReturn("John Doe");
        when(mockPassenger.getPassengerNumber()).thenReturn(123);
        when(mockPassenger.getSignedUpActivities()).thenReturn(Arrays.asList(mockActivity));
        when(mockActivity.getName()).thenReturn("Eiffel Tower Tour");
        when(mockActivity.getDestination()).thenReturn(mockDestination);
        when(mockActivity.getCost()).thenReturn(330.0);
        when(mockActivity.getCapacity()).thenReturn(15);
        travelPackage.addPassenger(mockPassenger);

        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printPassengerDetails(mockPassenger);

        // Assert expected output
        String expectedOutput = "Passenger Details:" + System.lineSeparator()+
                "  Name: John Doe" + System.lineSeparator()+
                "  Passenger Number: 123" + System.lineSeparator()+
                "  Balance: $0.0" + System.lineSeparator()+
                "  Activities Signed Up For:" + System.lineSeparator()+
                "    Activity: Eiffel Tower Tour at Destination: null (Price: $330.0)" + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());

        // Restore system output
        System.setOut(System.out);
    }

    @Test
    public void testPrintAvailableActivities() {
       // Mock destination and activity behavior
    when(mockDestination.getName()).thenReturn("Paris");
    
    // Ensure the mockActivity has a destination
    when(mockActivity.getName()).thenReturn("Eiffel Tower Tour");
    when(mockActivity.getDescription()).thenReturn("Guided tour of Eiffel Tower");
    when(mockActivity.getCost()).thenReturn(330.0);
    when(mockActivity.getCapacity()).thenReturn(15);
    when(mockActivity.getDestination()).thenReturn(mockDestination);

    when(mockDestination.getActivities()).thenReturn(Arrays.asList(mockActivity));
    travelPackage.addDestination(mockDestination);

    // Capture system output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    travelPackage.printAvailableActivities();

    // Assert expected output with platform-independent newline
    String expectedOutput = "Available Activities:" + System.lineSeparator() +
            "  Activity: Eiffel Tower Tour at Destination: Paris (Available Spaces: 15)" + System.lineSeparator();

    assertEquals(expectedOutput, outContent.toString());

    // Restore system output
    System.setOut(System.out);
}

@Test
public void testCountSignedUpPassengers() {
when(mockPassenger.getSignedUpActivities()).thenReturn(Arrays.asList(mockActivity));
travelPackage.addPassenger(mockPassenger);

int count = travelPackage.countSignedUpPassengers(mockActivity);

assertEquals(1, count);
}
}
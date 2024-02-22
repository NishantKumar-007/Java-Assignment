package com.travelers;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

       // Create Travel Package
       TravelPackage europeTour = new TravelPackage("Europe Tour", 20);

       // Create Destinations
       Destination paris = new Destination("Paris");
       Destination rome = new Destination("Rome");

       // Create Activities
       Activity parisActivity1 = new Activity("Eiffel Tower Tour", "Guided tour of Eiffel Tower", 330.0, 15, paris);
       Activity parisActivity2 = new Activity("Louvre Museum Visit", "Explore world-class art collections", 40.0, 20, paris);
       Activity romeActivity1 = new Activity("Colosseum Tour", "Historical tour of Colosseum", 60.0, 10, rome);
       Activity romeActivity2 = new Activity("Vatican City Visit", "Visit St. Peter's Basilica", 55.0, 12, rome);

       // Add Activities to Destinations
       paris.addActivity(parisActivity1);
       paris.addActivity(parisActivity2);
       rome.addActivity(romeActivity1);
       rome.addActivity(romeActivity2);

       // Add Destinations to Travel Package
       europeTour.addDestination(paris);
       europeTour.addDestination(rome);

       // Create Passengers
       StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);
       GoldPassenger goldPassenger = new GoldPassenger("Alice", 2, 150.0);
       PremiumPassenger premiumPassenger = new PremiumPassenger("Bob", 3);

       // Add Passengers to Travel Package
       europeTour.addPassenger(standardPassenger);
       europeTour.addPassenger(goldPassenger);
       europeTour.addPassenger(premiumPassenger);

       // Sign Up Passengers for Activities
       standardPassenger.signUpForActivity(parisActivity1);
       goldPassenger.signUpForActivity(parisActivity2);
       premiumPassenger.signUpForActivity(romeActivity1);

       // Print Itinerary
       europeTour.printItinerary();

       // Print Passenger List
       europeTour.printPassengerList();

       // Print Individual Passenger Details
       europeTour.printPassengerDetails(standardPassenger);
       europeTour.printPassengerDetails(goldPassenger);
       europeTour.printPassengerDetails(premiumPassenger);

       // Print Available Activities
       europeTour.printAvailableActivities();

    }
}
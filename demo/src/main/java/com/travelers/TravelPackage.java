package com.travelers;

import java.util.ArrayList;
import java.util.List;

class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private final List<Passenger> passengers;
    private final List<Destination> destinations;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("  Activity: " + activity.getName());
                System.out.println("    Description: " + activity.getDescription());
                System.out.println("    Cost: $" + activity.getCost());
                System.out.println("    Capacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("  Passenger: " + passenger.getName() + " (#" + passenger.getPassengerNumber() + ")");
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("  Name: " + passenger.getName());
        System.out.println("  Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger || passenger instanceof GoldPassenger) {
            System.out.println("  Balance: $" + passenger.getBalance());
        } else {
            System.out.println("  Balance: $" + passenger.getBalance());
        }
        System.out.println("  Activities Signed Up For:");
        for (Activity activity : passenger.getSignedUpActivities()) {
            System.out.println("    Activity: " + activity.getName() +
                    " at Destination: " + activity.getDestination().getName() +
                    " (Price: $" + activity.getCost() + ")");
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                int availableSpaces = activity.getCapacity() - countSignedUpPassengers(activity);
                if (availableSpaces > 0) {
                    System.out.println("  Activity: " + activity.getName() +
                            " at Destination: " + activity.getDestination().getName() +
                            " (Available Spaces: " + availableSpaces + ")");
                }
            }
        }
    }

    public int countSignedUpPassengers(Activity activity) {
        int count = 0;
        for (Passenger passenger : passengers) {
            if (passenger.getSignedUpActivities().contains(activity)) {
                count++;
            }
        }
        return count;
    }

}
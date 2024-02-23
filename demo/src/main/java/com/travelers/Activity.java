package com.travelers;


public class Activity {
    private final String name;
    private final String description;
    private final double cost;
    private int capacity;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }


    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return double
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return Destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * @param destination
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}

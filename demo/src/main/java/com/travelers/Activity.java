package com.travelers;


public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }
    
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getCost() {
        return cost;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Destination getDestination() {
        return destination;
    }    
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}

package com.travelers;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }
    public void signUpForActivity(Activity activity) {
    
        if (activity.getCapacity() == 0) {
            System.out.println("Sorry, activity " + activity.getName() + " at destination " +
                    activity.getDestination().getName() + " is already full.");
            return;
        }

        if (this instanceof GoldPassenger) {
            double discountedCost = 0.9 * activity.getCost();
            if(balance>=discountedCost){
                signedUpActivities.add(activity);
                balance -= discountedCost;
                activity.getDestination().decrementCapacity(activity);
            }
            else{
                System.out.println("insufficient balance");
            }    
        } else if (this instanceof StandardPassenger) {
            if(balance>=activity.getCost()){
                signedUpActivities.add(activity);
                balance -= activity.getCost();
                activity.getDestination().decrementCapacity(activity);
            }
            else{
                System.out.println("insufficient balance");
            }   
            
        }
        else{
            signedUpActivities.add(activity);
        }
    
    }
    

    
}

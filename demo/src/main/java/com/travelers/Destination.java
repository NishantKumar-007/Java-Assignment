package com.travelers;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }
    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }
    
    
    /** 
     * @return List<Activity>
     */
    public List<Activity> getActivities() {
        return activities;
    }
    

    
    /** 
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activity.getDestination() != null && activity.getDestination() != this) {
            System.out.println("Error: Activity " + activity.getName() + " is already associated with another destination.");
            return;
        }

        activities.add(activity);
        activity.setDestination(this);
    }
    
    public void decrementCapacity(Activity activity) {
        activity.setCapacity(activity.getCapacity() - 1);
    }
}

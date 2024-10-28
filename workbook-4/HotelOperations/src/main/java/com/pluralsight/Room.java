package com.pluralsight;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Room {
    private int beds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int beds, double price) {
        this.beds = beds;
        this.price = price;
        this.occupied = false;
        this.dirty = false;
    }
    public void getCheckIn(){
       if(isAvailable()) {
           dirty = true;
           occupied = true;
       }
   }
    public Boolean getCheckOut(){
        return !isOccupied() && !isDirty();
    }
    public void cleanRoom(){
            if(!isOccupied()){
                isDirty();
            }
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return false;
    }
    public Boolean isAvailable(){
        return !isDirty() && !isOccupied();
    }

}

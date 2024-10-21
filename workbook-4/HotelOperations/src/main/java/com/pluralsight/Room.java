package com.pluralsight;

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
        return dirty;
    }
    public Boolean isAvailable(){
        return !isDirty() && !isOccupied();
    }
}

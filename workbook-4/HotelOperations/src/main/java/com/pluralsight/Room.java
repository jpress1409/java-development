package com.pluralsight;

public class Room {
    private int beds;
    private double price;
    private boolean occupied;
    private boolean clean;

    public Room(int beds, double price, boolean occupied, boolean clean) {
        this.beds = beds;
        this.price = price;
        this.occupied = occupied;
        this.clean = clean;
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

    public boolean isClean() {
        return clean;
    }
}

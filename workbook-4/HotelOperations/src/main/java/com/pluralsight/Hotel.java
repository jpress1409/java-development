package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedSuites = 0;
        this.bookedRooms = 0;
    }

    public Hotel(String name, int numberOfRooms, int numberOfSuites) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }
    public boolean bookRoom(){
        if(getAvailableRooms() > 0){
            bookedRooms++;
            return true;
        }
        return false;
    }
    public boolean bookSuite(){
        if(getAvailableSuites() > 0){
            bookedSuites++;
            return true;
        }
        return false;
    }
    public int getAvailableRooms(){
        return numberOfRooms - bookedRooms;
    }
    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }

}

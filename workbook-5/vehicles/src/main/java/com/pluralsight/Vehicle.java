package com.pluralsight;

public class Vehicle {
    private String model;
    private String color;
    private int topSpeed;
    private int fuelCap;
    private int numberOfPassengers;
    private int cargoCap;

    public Vehicle() {
    }

    public Vehicle(String model, String color, int topSpeed, int fuelCap, int numberOfPassengers, int cargoCap) {
        this.model = model;
        this.color = color;
        this.topSpeed = topSpeed;
        this.fuelCap = fuelCap;
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCap = cargoCap;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getCargoCap() {
        return cargoCap;
    }

    public void setCargoCap(int cargoCap) {
        this.cargoCap = cargoCap;
    }
    public void startEngine(){

    }
    public void stopEngine(){

    }
    public void accelerate(){

    }
    public void brake(){

    }
}

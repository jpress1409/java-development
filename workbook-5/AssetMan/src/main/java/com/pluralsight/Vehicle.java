package com.pluralsight;

import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;
    private int now = Year.now().getValue();

    public Vehicle() {
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    @Override
    public double getValue(){
        int age = now - getYear();

        double  currentValue = 0;
        age = now - getYear();
        switch(age){

            case 0 -> getValue();
            case 1 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 2 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 3 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 4 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 5 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 6 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 7 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 8 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 9 -> currentValue = (getValue() / (1 + (.03 * age)));
            case 10 -> currentValue = (getValue() / (1 + (.03 * age)));
            default -> currentValue = 1000;
        }
        if(!getMakeModel().contains("Honda") || !getMakeModel().contains("Toyota")){
            if(getOdometer() > 100000){
                return currentValue / 1.25;
            }
        }
        return currentValue;
    }

}

package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition; // 1-excellent, 2-good, 3-fair, 4-poor
    private int squareFoot;
    private int lotSize;

    public House() {
    }

    @Override
    public double getVale() {
        return 0;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    protected double getValue(){

        double value = 0;

        switch(getCondition()){
            case 1 -> value = 130 * getSquareFoot();
            case 2 -> value = 130 * getSquareFoot();
            case 3 -> value = 130 * getSquareFoot();
            case 4 -> value = 130 * getSquareFoot();
        }
        value += (.25 * getSquareFoot());
        return value;
    }

    }


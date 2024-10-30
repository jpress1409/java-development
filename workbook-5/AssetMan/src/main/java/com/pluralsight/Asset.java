package com.pluralsight;

public abstract class Asset {
    private String description;
    private String dateAcquired;
    private double originalCost;

    public Asset() {

    }

    public double getVale(){
        return originalCost;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }

    protected abstract double getValue();
}

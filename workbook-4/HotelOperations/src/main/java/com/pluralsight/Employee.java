package com.pluralsight;

public class Employee {
    private double totalPay;
    private double regularHours;
    private double overtimeHours;

    public Employee(double totalPay, double regularHours, double overtimeHours) {
        this.totalPay = totalPay;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public double getRegularHours() {
        return regularHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }
}



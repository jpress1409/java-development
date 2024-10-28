package com.pluralsight;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchIn;
    public double punchOut;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;


    public Employee(String employeeID, String name, String department, double payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
        this.punchIn = 0;
        this.startTime = startTime;

    }
    public void punchIn(){
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minutes = now.getMinute();
        double startTime = (minutes / 60) + hour;

    }
    public void punchOut(){
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minutes = now.getMinute();
        double stopTime = (minutes / 60) + hour;

    }
    public void getPunchIn(double time){
        punchIn = time;
    }
    public void getPunchOut(double time){
        double duration = time - punchIn;
        hoursWorked += duration;
        punchIn = 0;
    }

    public double getTotalPay() {
    return (getRegularHours() * payRate) + (getOvertimeHours() * (payRate * 1.5));
    }


    public double getRegularHours() {
        if(hoursWorked > 40){
        return 40;
        }else {
            return hoursWorked;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked < 40) {
            return 0;
        }
        else{
            return hoursWorked - 40;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", payRate=" + payRate +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}



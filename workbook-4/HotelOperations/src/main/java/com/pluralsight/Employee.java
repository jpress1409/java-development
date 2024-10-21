package com.pluralsight;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;


    public Employee(String employeeID, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        if(hoursWorked < 40)
        return hoursWorked * payRate;
        else{
            return (getRegularHours() * payRate) +
                    (getOvertimeHours() * (payRate * 1.5));
        }
    }

    public double getRegularHours() {
        if(hoursWorked > 40){
        return 40;
        }else{
            return hoursWorked;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        }
        else{
            return 0;
        }
    }
}



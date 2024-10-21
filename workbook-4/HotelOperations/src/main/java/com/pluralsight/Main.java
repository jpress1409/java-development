package com.pluralsight;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static ArrayList<Employee> staff = new ArrayList<>(20);
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String employeeId, name, department;
        double hoursWorked, payRate;
        Reservation reservation = new Reservation();
        Room room = new Room();
        System.out.println("Please Enter your name:");
        name = scan.nextLine();
        int employeeIdNum = rand.nextInt();
        employeeId = Integer.toString(employeeIdNum);
        System.out.println("Please Enter your department: ");
        department = scan.nextLine();
        System.out.println("Please Enter you pay rate: ");
        payRate = scan.nextDouble();
        hoursWorked = 40;

        Employee employee = new Employee(employeeId, name, department, payRate, hoursWorked);
        for(Employee employee : staff){
            System.out.println(employee.getTotalPay());
        }

    }
}

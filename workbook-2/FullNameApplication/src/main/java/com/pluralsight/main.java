package com.pluralsight;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your fist name.");
        String firstName = scan.nextLine().trim();
        System.out.println("Please enter your middle name.");
        String middleName = scan.nextLine().trim();
        System.out.println("Please enter your last name.");
        String lastName = scan.nextLine().trim();
        System.out.println("Enter a suffix if you have one.");
        String suffix = scan.nextLine().trim();

        String fullName = firstName;
        if(middleName.isEmpty() && suffix.isEmpty()){
            System.out.println(fullName += lastName);
        }
        else if(!middleName.isEmpty())
        {
            System.out.println(firstName + " " + middleName + " " + lastName);
        }
        else
        {
            System.out.println(firstName + " " + middleName + " " + lastName + " ," + suffix);
        }
    }
}
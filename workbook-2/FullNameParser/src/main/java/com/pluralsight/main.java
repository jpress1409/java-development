package com.pluralsight;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String fullName;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your full name.");
        fullName = scan.nextLine();

        String[] nameParts = fullName.trim().split(" ");

        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];
        String middleName = nameParts.length > 2
                ? fullName.substring(firstName.length(), fullName.length() - lastName.length()).trim()
                : "";

        System.out.println("First Name: " + firstName);
        if (!middleName.isEmpty()) {
            System.out.println("Middle Name(s): " + middleName);
        }
        System.out.println("Last Name: " + lastName);
    }
}


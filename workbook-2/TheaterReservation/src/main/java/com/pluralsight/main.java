package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");



        System.out.println("Please enter your name (first and last):");
        String fullName = scan.nextLine();
        String[] nameParts = fullName.trim().split(" ");

        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];



        System.out.println("What date will you be coming (MM/dd/yyyy)?");
        String date = scan.nextLine();
        LocalDate formattedDate = LocalDate.parse(date, formatter);



        System.out.println("How many tickets would you like?");
        int ticketNum = scan.nextInt();

        if(ticketNum == 1) {
            System.out.println(ticketNum + " ticket reserved for " + formattedDate + " under " + lastName + ", " + firstName);
        }else{
            System.out.println(ticketNum + " tickets reserved for " + formattedDate + " under " + lastName + ", " + firstName);
        }
    }
}

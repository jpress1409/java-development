package com.pluralsight;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        String loop = ("Yes");
        double sandPrice = 0;
        double addOnPrice = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Sandwich Shop.");
        System.out.println("What size would you like?");
        System.out.println("1 for large ($8.95)");
        System.out.println("2 for small ($5.45)");
        int sandChoice = scan.nextInt();
        //While loop for confirmation
        do{
            //Selection fo sandwich size
            if (sandChoice == 1) {
                System.out.println("You would like a Large? ($8.95)");
                System.out.println("Is this correct?");
                loop = scan.next();
                sandPrice = 8.95;
                addOnPrice = 1.75;
            } else if (sandChoice == 2) {
                System.out.println("You would like a Small? ($5.45)");
                System.out.println("Is this correct?");
                loop = scan.next();
                addOnPrice = 1;
                sandPrice = 5.45;
            } else {
                System.out.println("Invalid Entry.");
            }
        }while(loop.equalsIgnoreCase("no"));
        //Add loaded option
        System.out.println("Would you like to make it loaded?");
        System.out.println("$1 for small or $1.75 for large");
        String addOn = scan.next();
        if(addOn.equalsIgnoreCase("yes")) {
            double newPrice =  sandPrice + addOnPrice;
            System.out.println("New total is "  + newPrice);
        }
        else{
            System.out.println("Total will be " + sandPrice);
        }
        //Age verification for discount and display final price
        System.out.println("How old are you?");
        int age = scan.nextInt();
        if (age < 18){
            System.out.println("You get a 10% discount!");
            double finalPrice = sandPrice / 1.1;
            System.out.println("Final Price: " + finalPrice);
        }
        else if(age > 64){
            System.out.println("You get a 20% discount!");
            double finalPrice = sandPrice / 1.2;
            System.out.println("Final Price: " + finalPrice);
        }
        else{
            System.out.println("Final Price: " + sandPrice);
        }
    }
}

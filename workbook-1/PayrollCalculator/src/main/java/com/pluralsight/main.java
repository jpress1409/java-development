package com.pluralsight;

import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = scan.nextInt();

        System.out.println("Enter second number: ");
        double num2 = scan.nextInt();

        System.out.println("What operation would you like to perform: ");
        System.out.println("'A'dd");
        System.out.println("'S'ubtract");
        System.out.println("'M'ultiply");
        System.out.println("'D'ivide");
        String op = scan.next();
        op.toLowerCase();

        switch(op) {
            case "a":
                System.out.println(num1 + num2);
                break;
            case "s":
                System.out.println(num1 - num2);
                break;
            case "m":
                System.out.println(num1 * num2);
                break;
            case "d":
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }
}

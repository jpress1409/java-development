package com.pluralsight;

import java.util.Scanner;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder shippingBuilder = new StringBuilder();
        StringBuilder billingBuilder = new StringBuilder();

        System.out.println("Please enter your name:");
        String name = scan.nextLine();

        System.out.println("Please enter your shipping address:");
        String shippingAddress = scan.nextLine();

        System.out.println("Please enter the city:");
        String shippingCity = scan.nextLine();

        System.out.println("Please enter state:");
        String shippingState = scan.nextLine();

        System.out.println("Please enter the zip");
        String shippingZip = scan.nextLine();

        shippingBuilder.append(shippingAddress).append("\n");
        shippingBuilder.append(shippingCity).append(", ");
        shippingBuilder.append(shippingState).append(" ");
        shippingBuilder.append(shippingZip);



        System.out.println("Please enter your Billing address:");
        String billingAddress = scan.nextLine();

        System.out.println("Please enter the city:");
        String billingCity = scan.nextLine();

        System.out.println("Please enter state:");
        String billingState = scan.nextLine();

        System.out.println("Please enter the zip");
        String billingZip = scan.nextLine();

        billingBuilder.append(billingAddress).append("\n");
        billingBuilder.append(billingCity).append(", ");
        billingBuilder.append(billingState).append(" ");
        billingBuilder.append(billingZip);


        String fullShippingAddress = shippingBuilder.toString();
        String fullBillingAddress = billingBuilder.toString();

        System.out.println(name);
        System.out.println(" ");
        System.out.println("Shipping Address:");
        System.out.println(fullShippingAddress);
        System.out.println(" ");
        System.out.println("Billing Address:");
        System.out.println(fullBillingAddress);


    }
}

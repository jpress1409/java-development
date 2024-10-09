package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scan = new Scanner(System.in);

        int command = 0;

    while (command != 5){
        System.out.println("What do you want to do?");
        System.out.println("Search by id? (1)");
        System.out.println("Sort by price? (2)");
        command = scan.nextInt();
    }
    switch(command){
        case 1:
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
            break;
    }

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f",
                    p.getId(), p.getName(), p.getPrice());
        }
    }


    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
                inventory.add(new Product (1 ,"Potatoes", 6.99F));
                inventory.add(new Product (2, "Tomatoes", 3.99F));
                inventory.add(new Product (3, "Peppers", 25.99F));
                inventory.add(new Product (4, "French Fries", 3.99F));
                inventory.add(new Product (4, "Hamburger", 11.89F));
        return inventory;
    }
}
package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> inventoryMap = new HashMap<>();


        loadInventoy(inventoryMap);

        Scanner scan = new Scanner(System.in);


if(){
    System.out.println("Enter an item: ");
    String name = scan.nextLine();
}else{
    System.out.println("The item id is ");
}


    }
    public static void loadInventoy(HashMap inventoryMap){
        String fileName = "inventory.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                Double price = Double.parseDouble(tokens[2]);
                inventoryMap.
            }



            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}

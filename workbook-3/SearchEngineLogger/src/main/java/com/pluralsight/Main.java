package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    private static final String LOG_FILE_NAME = "logs.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        logAction("Launch");

        Scanner scan = new Scanner(System.in);


        while(true){
            System.out.println("Enter a search term: ");
            String searchTerm = scan.nextLine();

            if("X".equalsIgnoreCase(searchTerm)){
                logAction("Exit");
                break;
            }else{
                logAction("Search: " + searchTerm);
            }

        }

        scan.close();
    }

    private static void logAction(String action){
        //Create writer inside try so it will automatically close.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true))) {

            writer.write(FORMATTER.format(LocalDateTime.now()) + " " + action);
            writer.newLine();


        }catch(Exception e){
            System.err.println("Error Writing to the Log File" + e.getMessage());
        }

        }

}

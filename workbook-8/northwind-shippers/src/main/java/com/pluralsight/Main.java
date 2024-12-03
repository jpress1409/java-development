package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (args.length != 2) {
            System.out.println("Username and Password are needed to connect to the Database!");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        Scanner scan = new Scanner(System.in);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);

        System.out.println("What would you like to do?");
        System.out.println("(1) See All Shippers");
        System.out.println("(2) Add New Shipper");
        System.out.println("(3) Delete Shipper");
        int choice = scan.nextInt();
        scan.nextLine();

        switch(choice) {

            case 1 -> {
                List<Shipper> shippers = dataManager.getAllShippers();
                shippers.forEach(System.out::println);
            }
            case 2 -> dataManager.addShipper(dataManager.createShipper());
            case 3 -> dataManager.deleteShipper();

        }

    }
}

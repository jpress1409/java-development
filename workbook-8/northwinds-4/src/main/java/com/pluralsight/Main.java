package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        // Check for command line arguments for username and password
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.pluralsight.Main <username> <password>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];
        String className = "com.mysql.cj.jdbc.Driver";

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1) Display all products");
            System.out.println("2) Display all customers");
            System.out.println("(3) Display all categories");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    displayAllProducts(username, password, className);
                    break;
                case 2:
                    displayAllCustomers(username, password, className);
                    break;
                case 3:
                    displayAllCategories(username, password, className);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayAllProducts(String username, String password, String className) throws SQLException, ClassNotFoundException{
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        Class.forName(className);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet results = statement.executeQuery()){


            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("Units In Stock: " + unitsInStock);
                System.out.println("-----------------------------------------");
            }
        }
    }

    private static void displayAllCustomers(String username, String password, String className)throws SQLException, ClassNotFoundException {
        Class.forName(className);

        String query = "SELECT ContactName, CompanyName, City, Country, Phone FROM Customers ORDER BY Country";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()){

            while (results.next()) {
                String contactName = results.getString("ContactName");
                String companyName = results.getString("CompanyName");
                String city = results.getString("City");
                String country = results.getString("Country");
                String phone = results.getString("Phone");

                System.out.println("Contact Name: " + contactName);
                System.out.println("Company Name: " + companyName);
                System.out.println("City: " + city);
                System.out.println("Country: " + country);
                System.out.println("Phone: " + phone);
                System.out.println("-----------------------------------------");
            }

        }
    }
    private static void displayAllCategories(String username, String password, String className)throws SQLException, ClassNotFoundException{
        Class.forName(className);

        String query = "SELECT CategoryId, CategoryName FROM categories ORDER BY CategoryId";

        try (Scanner scan = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()){

            while (results.next()) {
                int id = results.getInt("CategoryId");
                String name = results.getString("CategoryName");

                System.out.println("Contact Name: " + id);
                System.out.println("Company Name: " + name);
                System.out.println("-----------------------------------------");

            }

            selectProducts(username, password, className);
        }
    }
    private static void selectProducts(String username, String password, String className)throws SQLException, ClassNotFoundException{
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter ID of category to view:");
        String id = scan.nextLine();

        Class.forName(className);

        String query = "SELECT products.ProductID, products.ProductName, products.UnitPrice, products.UnitsInStock FROM products " +
                "INNER JOIN categories " +
                "ON products.CategoryID = categories.CategoryID" +
                "WHERE products.CategoryID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.){

            statement.setString(1, id);

            while(results.next()){
                int productID = results.getInt("ProductID");
                String name = results.getString("ProductName");
                double price = results.getDouble("UnitPrice");
                int stock = results.getInt("UnitsInStock");
                int catID = results.getInt("CategoryID");

                System.out.println("Product ID: " + productID);
                System.out.println("Product Name: " + name);
                System.out.println("Price: $" + price);
                System.out.println("Stock: " + stock);
                System.out.println("Category ID: " + catID);
                System.out.println("-----------------------------------------");
            }

        }

        scan.close();
    }
}
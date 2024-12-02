package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static String dbName = "jdbc:mysql://localhost:3306/northwind";
    private static String dbUser = "root";
    private static String dbPassword = "P@ssw0rd";

    public static void main(String[] args) {
        int option = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }


        while(option != 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("------------------------------------------------");
            System.out.println("(1) Display all products");
            System.out.println("(2) Display all customers");
            System.out.println("(3) exit");
            System.out.println("Select Options");
            System.out.println("------------------------------------------------");
            option = scan.nextInt();

            switch (option) {
                case 1 -> allProducts();
                case 2 -> allCustomers();
                case 3 -> System.out.println("Good-Bye");
            }
        }

    }
    public static void allProducts() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;

        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        System.out.printf("%-5s %-35s %-10s %-10s%n", "id", "name", "price", "stock");
        System.out.println("---------------------------------------------------------");

        try {

            connection = DriverManager.getConnection(dbName, dbUser, dbPassword);
            statement = connection.prepareStatement(query);
            results = statement.executeQuery();

            while (results.next()) {
                int id = results.getInt("ProductID");
                String name = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int inStock = results.getInt("UnitsInStock");

                System.out.printf("%-5s %-35s %-10.2f %-10d%n", id, name, unitPrice, inStock);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                results.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        public static void allCustomers () {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet results = null;

            String query = "SELECT CustomerID, CompanyName FROM customers";

            System.out.printf("%-10s %-35s%n", "id", "name");
            System.out.println("---------------------------------------------------------");

            try {
                connection = DriverManager.getConnection(dbName, dbUser, dbPassword);
                statement = connection.prepareStatement(query);
                results = statement.executeQuery();

                while (results.next()) {
                    String id = results.getString("CustomerID");
                    String name = results.getString("CompanyName");

                    System.out.printf("%-10s %-35s%n", id, name);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    results.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    // Handle exceptions during resource cleanup
                    e.printStackTrace();
                }
            }
        }
    }

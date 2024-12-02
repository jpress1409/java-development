package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       String username = args[0];
       String password = args[1];

       Class.forName("com.mysql.cj.jdbc.Driver");

       String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        System.out.printf("%-5s %-35s %-10s %-10s%n", "id", "name", "price", "stock");
        System.out.println("---------------------------------------------------------");

       try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password); PreparedStatement statement = connection.prepareStatement(query)){

           ResultSet results = statement.executeQuery();

        while(results.next()){
            int id = results.getInt("ProductID");
            String name = results.getString("ProductName");
            double unitPrice = results.getDouble("UnitPrice");
            int inStock = results.getInt("UnitsInStock");

            System.out.printf("%-5d %-35s %-10.2f %-10d%n", id, name, unitPrice, inStock);

        }

        results.close();

       }
    }
}

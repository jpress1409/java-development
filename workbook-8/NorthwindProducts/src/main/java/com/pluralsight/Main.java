package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "P@ssw0rd"
        );

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM products";

        ResultSet results = statement.executeQuery(query);

        System.out.println("Name: ");
        while(results.next()){
            String ProductName = results.getString("ProductName");

            System.out.println("    " + ProductName);
        }

        connection.close();
    }
}

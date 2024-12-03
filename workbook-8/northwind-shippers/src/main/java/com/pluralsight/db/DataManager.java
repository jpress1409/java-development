package com.pluralsight.db;

import com.pluralsight.models.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataManager {
    private DataSource dataSource;
    private Scanner scan = new Scanner(System.in);

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<Shipper> getAllShippers() throws SQLException {
        List<Shipper> shippers = new ArrayList<>();
        String query = "SELECT * FROM shippers";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet results = preparedStatement.executeQuery()){
            while(results.next()){
                int id = results.getInt(1);
                String name = results.getString(2);
                String phone = results.getString(3);

                Shipper shipper = new Shipper(id, name, phone);
                shippers.add(shipper);
            }
        }

        return shippers;
    }
    public Shipper createShipper(){

        System.out.println("Enter Company Name: ");
        String name = scan.nextLine();

        System.out.println("Enter Company Phone Number: ");
        String phone = scan.nextLine();

        return new Shipper(name, phone);
    }
    public void addShipper(Shipper shipper) throws SQLException{
        String query = "INSERT INTO shippers (CompanyName, Phone)" +
                "VALUES (?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, shipper.getCompanyName());
            preparedStatement.setString(2, shipper.getPhoneNumber());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted: " + rowsAffected);

            try(ResultSet results = preparedStatement.getGeneratedKeys()) {
                if (results.next()) {
                    int generatedId = results.getInt(1);
                    System.out.println("Generated Shipper ID: " + generatedId);
                }
            }
        }
    }
    public void deleteShipper() throws SQLException {
        List<Shipper> shippers = getAllShippers();

        String query = "DELETE FROM shippers WHERE ShipperID = ?";

        System.out.println("Enter Shipper ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);

            Iterator<Shipper> iterator = shippers.iterator();
            while (iterator.hasNext()) {
                Shipper shipper = iterator.next();
                if (shipper.getShipperId() == id) {
                    iterator.remove(); 
                    System.out.println("Shipper removed from local list.");
                }
            }
        }
    }
}

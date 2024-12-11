package com.pluralsight.northwindapi.dao.impl;

import com.pluralsight.northwindapi.dao.interfaces.IProductDao;
import com.pluralsight.northwindapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


@Component
public class JdbcProductDao implements IProductDao {

    private final DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String getAllQuery = "SELECT * FROM products";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
            ResultSet resultSet = selectStatement.executeQuery()){
            while(resultSet.next()){
                int productId = resultSet.getInt("ProductId");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String productName = resultSet.getString("ProductName");

                products.add(new Product(productId, productName, unitPrice));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        String getByIdQuery = "SELECT * FROM products WHERE ProductId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)){
            selectStatement.setInt(1, productId);

            try(ResultSet resultSet = selectStatement.executeQuery()){
                if(resultSet.next()){
                    int productIdFromDb = resultSet.getInt("ProductID");
                    double unitPrice = resultSet.getDouble("UnitPrice");
                    String productName = resultSet.getString("ProductName");

                    product = new Product(productIdFromDb, productName, unitPrice);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product add(Product product) {
        String insertQuery = "INSERT INTO products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)){

            insertStatement.setString(1, product.getProductName());
            insertStatement.setInt(2, product.getCategoryId());
            insertStatement.setDouble(3, product.getUnitPrice());
            int affectedRows = insertStatement.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating Product Failed");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    int generatedProductId = generatedKeys.getInt(1);
                    product.setProductId(generatedProductId);
                }else{
                    throw new SQLException("Creating Product Failed");
                }

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(int productId, Product product) {
        String updateQuery = "UPDATE products SET ProductName = ?, UnitPrice = ? WHERE ProductId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){

            updateStatement.setString(1, product.getProductName());
            updateStatement.setDouble(2, product.getUnitPrice());
            updateStatement.setInt(3, productId);
            updateStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int productId) {
        String deleteQuery = "DELETE FROM products WHERE ProductId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)){

            deleteStatement.setInt(1, productId);
            deleteStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}

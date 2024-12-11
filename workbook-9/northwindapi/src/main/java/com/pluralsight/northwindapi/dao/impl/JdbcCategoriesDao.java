package com.pluralsight.northwindapi.dao.impl;

import com.pluralsight.northwindapi.dao.interfaces.ICategoryDao;
import com.pluralsight.northwindapi.models.Category;
import com.pluralsight.northwindapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoriesDao implements ICategoryDao {
    private DataSource dataSource;

    @Autowired
    public JdbcCategoriesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String getAllQuery = "SELECT * FROM categories";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
            ResultSet resultSet = selectStatement.executeQuery()){
            while(resultSet.next()){
                int categoryId = resultSet.getInt("CategoryID");
                String categoryName = resultSet.getString("CategoryName");

                categories.add(new Category(categoryName, categoryId));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        Category category = null;
        String getByIdQuery = "SELECT * FORM category WHERE CategoryId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)){
            selectStatement.setInt(1, categoryId);

            try(ResultSet resultSet = selectStatement.executeQuery()){
                if(resultSet.next()){
                    int categoryIdFromDb = resultSet.getInt("CategoryID");
                    String productName = resultSet.getString("CategoryName");

                    category = new Category(productName, categoryIdFromDb);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category add(Category category){
        String insertQuery = "INSERT INTO categories (CategoryName) Values(?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, category.getName());
            int affectedRows = insertStatement.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating Category Failed");
            }
            try(ResultSet generatedKeys = insertStatement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    int generatedId = generatedKeys.getInt(1);
                    category.setCategoryId(generatedId);
                }else {
                    throw new SQLException("Creating Category Failed");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(int categoryId, Category category) {
        String updateQuery = "UPDATE categories SET CategoryName = ? WHERE CategoryId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){

            updateStatement.setString(1, category.getName());
            updateStatement.setInt(2, categoryId);
            updateStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId) {
        String deleteQuery = "DELETE FROM categories WHERE CategoryId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)){

            deleteStatement.setInt(1, categoryId);
            deleteStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
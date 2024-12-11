package com.pluralsight.northwindapi.dao.interfaces;

import com.pluralsight.northwindapi.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {


    List<Category> getAllCategories() ;

    Category getCategoryById(int categoryId);

    Category add(Category category);

    void update(int categoryId, Category category);

    void delete(int categoryId);
}

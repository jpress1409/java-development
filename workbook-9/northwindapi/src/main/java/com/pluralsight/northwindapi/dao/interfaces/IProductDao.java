package com.pluralsight.northwindapi.dao.interfaces;

import com.pluralsight.northwindapi.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {

    List<Product> getAllProducts();

    Product getProductById(int productId);

    Product add(Product product);

    void update(int productId, Product product);

    void delete(int productId);
}

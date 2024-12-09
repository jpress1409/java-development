package com.pluralsight.NorthwindTradersSpringBoot.dao.interfaces;



import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface IProductDao {
    Product insert(Product product);

    List<Product> getAll();

    Product getById(int productId);

    void update(int productId, Product product);

    void delete(int productId);
}
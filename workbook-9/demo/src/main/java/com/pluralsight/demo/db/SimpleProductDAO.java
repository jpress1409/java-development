package com.pluralsight.demo.db;

import com.pluralsight.demo.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SimpleProductDAO implements ProductDAO{
    private List<Product> products = new ArrayList<>();

    public SimpleProductDAO() {
        products.add(new Product(1, "Laptop", "Electronics", 1200.00));
        products.add(new Product(2, "Chair", "Furniture", 150.00));
        products.add(new Product(3, "Notebook", "Stationery", 5.00));
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}

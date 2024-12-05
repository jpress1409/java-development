package com.pluralsight.demo.db;

import com.pluralsight.demo.models.*;

import java.util.List;

public interface ProductDAO {
    void add(Product product);
    List<Product> getAll();

}

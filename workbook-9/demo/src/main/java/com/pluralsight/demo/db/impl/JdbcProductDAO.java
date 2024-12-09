package com.pluralsight.demo.db.impl;

import com.pluralsight.demo.db.infc.IProductDao;
import com.pluralsight.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;
import java.util.List;

public class JdbcProductDAO implements IProductDao {

    private DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Product insert(Product product) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product getById(int productId) {
        return null;
    }

    @Override
    public void update(int productId, Product product) {

    }

    @Override
    public void delete(int productId) {

    }
}

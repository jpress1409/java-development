package com.pluralsight.northwindapi.controllers;

import com.pluralsight.northwindapi.dao.interfaces.IProductDao;
import com.pluralsight.northwindapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductsController {
    private final IProductDao productDao;

    @Autowired
    public ProductsController(IProductDao productDao){
        this.productDao = productDao;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        return productDao.getProductById(productId);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        return productDao.add(product);
    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable int productId, Product product) {
        productDao.update(productId, product);
    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int productId) {
        productDao.delete(productId);
    }

}

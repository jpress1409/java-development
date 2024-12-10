package com.pluralsight.northwindapi.controllers;

import com.pluralsight.northwindapi.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class ProductsController {
    private List<Product> products;

    public ProductsController(){
        products = new ArrayList<>();

        //add products here
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return products;
    }
    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Return null if transaction with given ID is not found
    }

}

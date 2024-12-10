package com.pluralsight.northwindapi.controllers;

import com.pluralsight.northwindapi.models.Category;
import com.pluralsight.northwindapi.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatergoriesController {
    private final List<Category> categories;

    public CatergoriesController() {
        List<Product> categories = new ArrayList<>();

        //add categories here
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categories;
    }
    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryId(@PathVariable int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null; // Return null if transaction with given ID is not found
    }
}

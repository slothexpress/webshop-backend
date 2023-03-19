package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class AppController {

    AppService service;

    @Autowired
    public AppController(AppService service) {
        this.service = service;
    }

    // Root endpoint returns all products
    @GetMapping("/")
    public HashMap<Integer, Product> getAllProducts() {
        HashMap<Integer, Product> allProducts = service.getMockDatabase();
        return allProducts;
    }

    // Get product by id
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        return product;
    }

    @PostMapping("/delete/{id}")
    public String deleteProductById(@PathVariable int id) {
        String response = service.deleteProductById(id);
        return response;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        System.out.println("PRODUCT " + product);

        String response = service.addProduct(product);
        return response;
    }



}

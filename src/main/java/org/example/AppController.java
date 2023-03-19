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
    @GetMapping("/api")
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

    @PostMapping("/add/{title}/{price}/{description}/{category}/{image}")
    public String addProduct(@PathVariable String title, @PathVariable int price,
                             @PathVariable String description, @PathVariable String category,
                             @PathVariable String image) {
        Product product = new Product(title, price, description, category, image);
        String response = service.addProduct(product);
        return response;
    }


}

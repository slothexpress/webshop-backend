package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@CrossOrigin
public class AppController {

    @Autowired
    AppService service;

    @Autowired
    public AppController(AppService service) {
        this.service = service;
    }

    // DUMMY ENDPOINT FOR TEST
    @GetMapping("/test/{input}")
    public ResponseEntity<String> dummyEndpoint(@PathVariable String input) {
        return new ResponseEntity<>("HALLO " + input, HttpStatus.OK);
    }

    // Root endpoint returns all products
    @GetMapping("/api")
    public ResponseEntity<HashMap<Integer, Product>> getAllProducts() {
        HashMap<Integer, Product> allProducts = service.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
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

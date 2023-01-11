package kodtest.omegapoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    Service service;

    public RestController() throws JsonProcessingException {
        service = new Service();
    }

    // Root endpoint returns all products
    @GetMapping("/")
    public HashMap<Integer, Product> getAllProducts() {
        HashMap<Integer, Product> allProducts = service.getMockDatabase();
        return allProducts;
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        return product;
    }

}

package kodtest.omegapoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

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

}

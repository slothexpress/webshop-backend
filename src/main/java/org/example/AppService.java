package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@Service
public class AppService {

    //@Autowired (if real repository from DB)
    private HashMap<Integer, Product> mockDatabase = new HashMap<>();

    @Autowired
    public AppService() throws JsonProcessingException {
        System.out.println("CREATING SERVICE");
        fetchAPI();
    }

    public HashMap<Integer, Product> getAllProducts() {
        return mockDatabase;
    }

    public String fetchAPI() throws JsonProcessingException {
        String result = "null";
        String line;
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL("https://fakestoreapi.com/products");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if(responseCode == 200) {
                BufferedReader data = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while((line = data.readLine()) != null) {
                    content.append(line);
                }
            }
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Fetch threw exception: " + e);
        }
        result = content.toString();
        saveProducts(result);

        System.out.println("FETCHED API DONE ");
        System.out.println("RESULT: " + result);
        return result;
    }

    private void saveProducts(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        List<JsonNode> jsonObjects = rootNode.findParents("rating");
        HashMap<Integer, Product> products = new HashMap();

        for (JsonNode object : jsonObjects) {
            int id = Integer.parseInt(object.get("id").toString());
            String title = object.get("title").toString();
            double price = Double.parseDouble(object.get("price").toString());
            String description = object.get("description").toString();
            String category = object.get("category").toString();
            String image = object.get("image").toString();

            Product product = new Product(title, price, description, category, image);
            products.put(id, product);
        }

        mockDatabase = products;
        System.out.println(" SAVED PRODUCTS " + products);
    }

    public Product getProductById(int id) {
        if(mockDatabase.get(id) != null) {
            return mockDatabase.get(id);
        } else {
            // If id does not exist, return empty product with error message
            return new Product(id);
        }
    }

    public String deleteProductById(int id) {
        if(mockDatabase.get(id) != null) {
            mockDatabase.remove(id);
            return "Deleted product with ID " + id;
        } else {
            // If id does not exist, return empty product with error message
            return "Product with ID " + id + " does not exist";
        }
    }

    public String addProduct(Product product) {
        int id;
        int counter = 0;

        // Fix potential infinite loop
        do {
            counter++;
            id = mockDatabase.size() + counter;
        } while (mockDatabase.containsKey(id));

        mockDatabase.put(id, product);
        return "Product added!";
    }



}

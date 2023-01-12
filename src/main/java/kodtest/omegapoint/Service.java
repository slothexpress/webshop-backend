package kodtest.omegapoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private HashMap<Integer, Product> mockDatabase = new HashMap<>();

    @Autowired
    public Service() throws JsonProcessingException {
        fetchAPI();
    }

    public HashMap<Integer, Product> getMockDatabase() {
        return mockDatabase;
    }

    public String fetchAPI() throws JsonProcessingException {
        String result = "null";
        String line;
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL("https://kodtest.azurewebsites.net/api/products?code=MWZOJunmBNEPDGxldyIKSplsqq/8Sv4c6KvgZ1vyh4Z9wCaw6rqJIA==");
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
        return result;
    }

    public void saveProducts(String json) throws JsonProcessingException {

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

            JsonNode ratingObject = object.get("rating");
            double rate = Double.parseDouble(ratingObject.get("rate").toString());
            int count = Integer.parseInt(ratingObject.get("count").toString());
            Rating rating = new Rating(rate, count);

            Product product = new Product(title, price, description, category, image, rating);
            products.put(id, product);
        }

        mockDatabase = products;
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
        int counter = 0;
        int id;

        // Fix potential infinite loop
        do {
            counter++;
            id = mockDatabase.size() + counter;
        } while (mockDatabase.containsKey(id));

        mockDatabase.put(id, product);
        return "Product added!";
    }
}

package org.example;

import com.google.gson.Gson;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;

@SpringBootTest
public class AppServiceTests {


    @Autowired
    AppService sut;

    Gson gson = new Gson();

    static String expectedProducts;
    static String expectedProduct;

    @BeforeAll
    public static void setup() {
        setupProductById();
        setupAllProducts();
    }

    private static void setupProductById() {String userDirectory = System.getProperty("user.dir");
        String filePath = "/src/test/resources/";
        String fileName = "Product.json";
        String content = "";

        try {
            content = new String(Files.readAllBytes(
                    Paths.get(userDirectory + filePath + fileName)), StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        expectedProduct = content;

    }

    public static void setupAllProducts() {
        String userDirectory = System.getProperty("user.dir");
        String filePath = "/src/test/resources/";
        String fileName = "AllProducts.json";
        String content = "";

        try {
            content = new String(Files.readAllBytes(
                    Paths.get(userDirectory + filePath + fileName)), StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        expectedProducts = content;
    }

    @Test
    public void getAllProductsTest() throws JSONException {
        HashMap<Integer, Product> products = sut.getAllProducts();
        String actualProducts = gson.toJson(products);

        Assert.assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void getProductByIdTest() throws JSONException {
        Product product = sut.getProductById(1);
        String actualProduct = gson.toJson(product);

        Assert.assertEquals(expectedProduct, actualProduct);
    }


}

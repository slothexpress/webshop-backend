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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppServiceTests {


    @Autowired
    AppService sut;

    Gson gson = new Gson();

    static String expectedProducts;
    static String expectedProduct;


    private static String setupExpectedData(String fileName) {
        String userDirectory = System.getProperty("user.dir");
        String filePath = "/src/test/resources/";
        String content = "";

        try {
            content = new String(Files.readAllBytes(
                    Paths.get(userDirectory + filePath + fileName)), StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    // Currently must be run first
    // Due to add and delete test changes the data
    @Test
    @Order(1)
    public void getAllProductsTest() throws JSONException {
        expectedProducts = setupExpectedData("AllProducts.json");

        HashMap<Integer, Product> products = sut.getAllProducts();
        String actualProducts = gson.toJson(products);

        Assert.assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void getProductByIdTest() throws JSONException {
        expectedProduct = setupExpectedData("Product.json");

        Product product = sut.getProductById(1);
        String actualProduct = gson.toJson(product);

        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void addProductTest() throws JSONException {
        Product product = new Product();
        String result = sut.addProduct(product);

        // TODO UPDATE WHEN REAL DATABASE EXISTS
        Assert.assertEquals("Product added!", result);
    }

    @Test
    public void deleteProductById() throws JSONException {
        int id = 2;
        String result = sut.deleteProductById(id);


        // TODO UPDATE WHEN REAL DATABASE EXISTS
        Assert.assertEquals("Deleted product with ID " + id, result);
    }

    @Test
    public void deleteProductByIdThatDoesNotExist() throws JSONException {
        int id = 111;
        String result = sut.deleteProductById(id);

        // TODO UPDATE WHEN REAL DATABASE EXISTS
        Assert.assertEquals("Product with ID " + id + " does not exist", result);
    }

}

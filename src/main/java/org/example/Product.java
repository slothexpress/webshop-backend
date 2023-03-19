package org.example;

public class Product {

    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    // Add new product
    public Product(String title, double price, String description, String category, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    // Constructor for non-existing product id
    public Product(int id) {
        this.title = "PRODUCT ID:";
        this.price = id;
        this.description = "DOES";
        this.category = "NOT";
        this.image = "EXIST";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

package org.example;

public class Product {


    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    public Product(String title, double price, String description, String category, String image, Rating rating) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    public Product(int id) {
        this.title = "Product with ID " + id + " does not exist";
        this.price = 0;
        this.description = "";
        this.category = "";
        this.image = "";
        this.rating = null;
    }

    public Product(String title, double price, String description, String category, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = new Rating();
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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}

package com.app.compare.common;

import java.util.ArrayList;

public class AmazonProduct {
    private String productTitle;
    private String asin;
    private String manufacturer; //soldby
    private String productRating;
    private String productDescription;
    private String amazonUrl;

    private int countReview;
    private double retailPrice;
    private double price;

    private ArrayList<ProductDetail> productDetails;
    private ArrayList<Review> productReviews;
    private ArrayList<String> categories;
    private ArrayList<String> imageUrlList;

    public AmazonProduct() {
    }

    // setters
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public void setManufacturer(String manufacturer) {
        // soldby
        this.manufacturer = manufacturer;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setCountReview(int countReview) {
        this.countReview = countReview;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductDetails(ArrayList<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public void setProductReviews(ArrayList<Review> productReviews) {
        this.productReviews = productReviews;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void setImageUrlList(ArrayList<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public void setAmazonUrl(String amazonUrl) {
        this.amazonUrl = amazonUrl;
    }

     // getters
    public String getProductTitle() {
        return this.productTitle;
    }

    public String getAsin() {
        return this.asin;
    }

    public String getManufacturer() {
        // soldby
        return this.manufacturer;
    }

    public String getProductRating() {
        return this.productRating;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public int getCountReview() {
        return this.countReview;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public ArrayList<ProductDetail> getProductDetails() {
        return this.productDetails;
    }

    public ArrayList<Review> getProductReviews() {
        return this.productReviews;
    }

    public ArrayList<String> getCategories() {
        return this.categories;
    }

    public ArrayList<String> getImageUArrayList() {
        return this.imageUrlList;
    }

    public String getAmazonUrl() {
        return this.amazonUrl;
    }
}
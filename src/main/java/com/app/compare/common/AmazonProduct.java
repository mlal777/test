package com.app.compare.common;

import java.util.ArrayList;

public class AmazonProduct {
    private String productTitle;
    private String asin;
    private String manufacturer;
    private String productDescription;
    private String amazonUrl;
    private String salesRank;
    private String productDimension;
    private String heroCategory;
    private String itemModel;

    private int numReviews;
    private double price;
    private double productRating;

    private boolean isPrime;

    private ArrayList<String> productDetails;
    private ArrayList<Review> productReviews;
    private ArrayList<String> categories;
    private ArrayList<String> imageUrlList;
    private ArrayList<String> reviewsMention;

    public AmazonProduct() {
    }

    // setters
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public void setHeroCategory(String heroCategory) {
        this.heroCategory = heroCategory;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public void setManufacturer(String manufacturer) {
        // soldby
        this.manufacturer = manufacturer;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductDetails(ArrayList<String> productDetails) {
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

    public void setReviewsMention(ArrayList<String> reviewsMention) {
        this.reviewsMention = reviewsMention;
    }

    public void setAmazonUrl(String amazonUrl) {
        this.amazonUrl = amazonUrl;
    }

    public void setSalesRank(String salesRank) {
        this.salesRank = salesRank;
    }

    public void setProductDimension(String productDimension) {
        this.productDimension = productDimension;
    }

    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
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

    public double getProductRating() {
        return this.productRating;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public int getNumReviews() {
        return this.numReviews;
    }

    public double getPrice() {
        return this.price;
    }

    public ArrayList<String> getProductDetails() {
        return this.productDetails;
    }

    public ArrayList<Review> getProductReviews() {
        return this.productReviews;
    }

    public ArrayList<String> getCategories() {
        return this.categories;
    }

    public ArrayList<String> getImageUrlList() {
        return this.imageUrlList;
    }

    public ArrayList<String> getReviewsMention() {
        return this.reviewsMention;
    }

    public String getAmazonUrl() {
        return this.amazonUrl;
    }

    public String getSalesRank() {
        return this.salesRank;
    }

    public String getProductDimension() {
        return this.productDimension;
    }

    public boolean getIsPrime() {
        return this.isPrime;
    }

    public String getHeroCategory() {
        return this.heroCategory;
    }

    public String getItemModel() {
        return this.itemModel;
    }
}
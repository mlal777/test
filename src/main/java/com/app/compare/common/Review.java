package com.app.compare.common;

public class Review {
    public String text;
    public String date;
    public String rating;
    public String title;
    public String userName;
    public String url;

    public Review() {
    }

    public void setReviewText(String text) {
        this.text = text;
    }

    public String getReviewText() {
        return this.text;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return this.rating;
    }
}
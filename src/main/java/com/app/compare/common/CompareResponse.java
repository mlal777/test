package com.app.compare.common;

import java.util.List;

import com.app.compare.common.AmazonProduct;

public class CompareResponse {
    private List<AmazonProduct> amazonProducts;
    private String errorResponse;
    
    public CompareResponse() {
    }

    public void setAmazonProducts(List<AmazonProduct> amazonProducts) {
        this.amazonProducts = amazonProducts;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public List<AmazonProduct> getAmazonProducts() {
        return this.amazonProducts;
    }

    public String getErrorResponse() {
        return this.errorResponse;
    }

}
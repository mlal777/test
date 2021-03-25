package com.app.compare.common;

import java.net.http.HttpResponse;
import com.google.gson.Gson;

public final class ResponseParser {

    public static AmazonProduct getAmazonProduct(HttpResponse<String> response){
        AxessoProductLookUpDTO axessoProductLookUpDTO = new Gson().fromJson(response.body(), AxessoProductLookUpDTO.class);
        
        AmazonProduct amazonProduct = new AmazonProduct(axessoProductLookUpDTO.productTitle, axessoProductLookUpDTO.asin);
        amazonProduct.setManufacturer(axessoProductLookUpDTO.manufacturer);
        amazonProduct.setProductDescription(axessoProductLookUpDTO.productDescription);
        amazonProduct.setCountReview(axessoProductLookUpDTO.countReview);
        amazonProduct.setRetailPrice(axessoProductLookUpDTO.retailPrice);
        amazonProduct.setPrice(axessoProductLookUpDTO.price);
        amazonProduct.setProductDetails(axessoProductLookUpDTO.productDetails);
        amazonProduct.setProductReviews(axessoProductLookUpDTO.reviews);
        amazonProduct.setCategories(axessoProductLookUpDTO.categories);
        
        return amazonProduct;
    }
} 
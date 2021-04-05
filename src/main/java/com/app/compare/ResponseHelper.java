package com.app.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.app.compare.common.AmazonProduct;
import com.app.compare.common.ProductDetail;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Value;

public class ResponseHelper {
    public static AmazonProduct parseEntityToAmazonProduct(Entity entity) {
        AmazonProduct amazonProduct = new AmazonProduct();
        amazonProduct.setAsin(entity.getString("asin"));
        amazonProduct.setAmazonUrl(entity.getString("amazonUrl"));
        amazonProduct.setProductTitle(entity.getString("productTitle"));
        amazonProduct.setManufacturer(entity.getString("manufacturer"));
        amazonProduct.setProductRating(entity.getString("productRating"));
        amazonProduct.setProductDescription(entity.getString("productDescription"));

        amazonProduct.setPrice(entity.getDouble("price"));
        amazonProduct.setRetailPrice(entity.getDouble("retailPrice"));
        amazonProduct.setCountReview((int) entity.getLong("countReview"));

        List<Value<String>> resultCategories = entity.getList("categories");
        List<Value<String>> resultImageUrlList = entity.getList("imageUrlList");
        List<Value<Entity>> resultProductDetails = entity.getList("productDetails");

        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<String> imageUrlList = new ArrayList<>();

        for (Value<String> category : resultCategories) {
            categories.add(category.get());
        }
        amazonProduct.setCategories(categories);

        for (Value<String> image : resultImageUrlList) {
            imageUrlList.add(image.get());
        }
        amazonProduct.setImageUrlList(imageUrlList);

        /*
        for (Value<Entity> resultProductDetail : resultProductDetails) {
            Entity detail = resultProductDetail.get();
            String name = detail.getString("name");
            String value = detail.getString("value");
            ProductDetail productDetail = new ProductDetail(name, value);
            productDetails.add(productDetail);
        }
        amazonProduct.setProductDetails(productDetails); */
        return amazonProduct;
    }

    public static HashMap<AmazonProduct, Double> sortByValue(HashMap<AmazonProduct, Double> map) {
        // Create a list from elements of HashMap
        List<Map.Entry<AmazonProduct, Double>> list = new LinkedList<Map.Entry<AmazonProduct, Double>>(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<AmazonProduct, Double>>() {
            @Override
            public int compare(Entry<AmazonProduct, Double> o1, Entry<AmazonProduct, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
          
        // put data from sorted list to hashmap 
        HashMap<AmazonProduct, Double> temp = new LinkedHashMap<AmazonProduct, Double>();
        for (Map.Entry<AmazonProduct, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
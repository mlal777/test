package com.app.compare.scoring;

import java.util.Set;

import com.app.compare.common.AmazonProduct;

public class Score {

    public static double getEntityPriceScore(AmazonProduct product, double priceToCompare) {
        return Math.abs(product.getPrice() - priceToCompare);
    }

    public static boolean entitiesShareEnoughCategories(AmazonProduct amazonProduct, Set<String> categories) {
        float desiredRatio = 0.5f;
        int count = 0;
        for (String category : amazonProduct.getCategories()) {
            if (categories.contains(category)) {
                count++;
            }
        }
        return count/categories.size() >= desiredRatio ? true : false;
    }
}
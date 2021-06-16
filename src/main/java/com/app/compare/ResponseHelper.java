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
import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;

import com.app.compare.common.AmazonProduct;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Value;

public class ResponseHelper {
    public static AmazonProduct parseEntityToAmazonProduct(Entity entity) {
        AmazonProduct amazonProduct = new AmazonProduct();
        try {
            amazonProduct.setAsin(entity.getString("ASIN"));
            amazonProduct.setAmazonUrl(entity.getString("product_link"));
            amazonProduct.setProductTitle(entity.getString("Product_Name"));
            amazonProduct.setManufacturer(entity.getString("manufacturer"));
            amazonProduct.setProductRating(getRating(entity));
            amazonProduct.setProductDescription(entity.getString("Product_Description"));
            amazonProduct.setHeroCategory(entity.getString("category"));
            amazonProduct.setSalesRank(entity.getString("sales_rank_final"));
            amazonProduct.setProductDimension(entity.getString("product_Dimension"));
            amazonProduct.setItemModel(entity.getString("Item_Model_Number"));

            amazonProduct.setPrice(parsePriceToDouble(entity.getString("Current_Price")));
            amazonProduct.setNumReviews(parseStringToInt(entity.getString("reviews")));

            List<Value<String>> resultCategories = entity.getList("sub_categories");
            List<Value<String>> resultImageUrlList = entity.getList("other_images");
            List<Value<String>> resultProductDetails = entity.getList("Description");
            List<Value<String>> resultReviewsMention = entity.getList("reviews_mention");

            int isPrime = (int) entity.getLong("prime");

            amazonProduct.setIsPrime(isPrime == 1 ? true : false);

            amazonProduct.setCategories(parseList(resultCategories));
            amazonProduct.setImageUrlList(parseList(resultImageUrlList));
            amazonProduct.setProductDetails(parseList(resultProductDetails));
            amazonProduct.setReviewsMention(parseList(resultReviewsMention));

            // Include main image url at the top of image list.
            amazonProduct.getImageUrlList().add(0, entity.getString("Image_URL"));

            return amazonProduct;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return amazonProduct;
        }
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

    private static ArrayList<String> parseList(List<Value<String>> inputList) {
        ArrayList<String> returnList = new ArrayList<>();
        for (Value<String> item : inputList) {
            returnList.add(item.get());
        }
        return returnList;
    }

    private static double parsePriceToDouble(String price) {
        try {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            return format.parse(price).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    private static int parseStringToInt(String input) {
        try {
            NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
            return format.parse(input).intValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static double getRating(Entity entity) {
        try {
            return entity.getDouble("Rating");
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
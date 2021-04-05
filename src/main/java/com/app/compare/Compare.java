package com.app.compare;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.app.compare.common.AmazonProduct;
import com.app.compare.common.CompareResponse;
import com.app.compare.common.StringParsers;
import com.app.compare.scoring.Score;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.QueryResults;

@Path("/compare")
public class Compare {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompareResponse get(@QueryParam("product_url") String product_url) {
        CompareResponse compareResponse = new CompareResponse();
        if (product_url == null || product_url.isEmpty()) {
            compareResponse.setErrorResponse("Please input an amazon url or product number");
            return compareResponse;
        }

        // Instantiates a client
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        String asin = StringParsers.getAsinFromAmazonUrl(product_url);

        if (asin.isEmpty()) {
            return compareResponse;
        }
        Query<Entity> query = Query.newEntityQueryBuilder()
                                    .setKind("AmazonProduct")
                                    .setFilter(PropertyFilter.eq("asin", asin))
                                    .build();
        QueryResults<Entity> results = datastore.run(query);
        ArrayList<Entity> entities = new ArrayList<>();
        
        if (!results.hasNext()) {
            return compareResponse;
        }

        while(results.hasNext()) {
            entities.add(results.next());
        }

        // Get what should be the first and only item corresponding to the product asin.
        Entity resultEntity = entities.get(0);
        AmazonProduct requestedAmazonProduct = ResponseHelper.parseEntityToAmazonProduct(resultEntity);

        // Get all other entries that share the same categories as the requested Amazon Product.
        Set<String> categorySet = new HashSet<>();
        Set<String> uniqueAsins = new HashSet<>();
        uniqueAsins.add(requestedAmazonProduct.getAsin());

        HashMap<AmazonProduct, Double> allAmazonProducts = new HashMap<AmazonProduct, Double>();

        for (String category : requestedAmazonProduct.getCategories()) {
            categorySet.add(category);
            Query<Entity> categoryQuery = Query.newEntityQueryBuilder()
                                    .setKind("AmazonProduct")
                                    .setFilter(PropertyFilter.eq("categories", category))
                                    .build();
            QueryResults<Entity> categoryResults = datastore.run(categoryQuery);
            while (categoryResults.hasNext()) {
                Entity returnedEntity = categoryResults.next();
                String returnedAsin = returnedEntity.getString("asin");
                if (!uniqueAsins.contains(returnedAsin)) {
                    uniqueAsins.add(returnedAsin);
                    AmazonProduct product = ResponseHelper.parseEntityToAmazonProduct(returnedEntity);
                    if (Score.entitiesShareEnoughCategories(product, categorySet)) {
                        double priceScore = Score.getEntityPriceScore(product, requestedAmazonProduct.getPrice());
                        allAmazonProducts.put(product, priceScore);
                    }
                }
            }
        }

        Map<AmazonProduct, Double> sortByPriceMap = ResponseHelper.sortByValue(allAmazonProducts);
        ArrayList<AmazonProduct> amazonProducts = new ArrayList<>();
        amazonProducts.add(requestedAmazonProduct);
        
        // Insert the sorted hashmap into final response
        int maxCount = 3;
        int count = 0;
        for (Map.Entry<AmazonProduct, Double> entry : sortByPriceMap.entrySet()) {
            if (count >= maxCount) {
                break;
            }
            amazonProducts.add(entry.getKey());
            count++;
        }
        compareResponse.setAmazonProducts(amazonProducts);
        return compareResponse;
    }
}
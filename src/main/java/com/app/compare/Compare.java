package com.app.compare;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.app.compare.common.AmazonProduct;
import com.app.compare.common.CompareResponse;
import com.app.compare.common.ResponseParser;

@Path("/compare")
public class Compare {

    private static final String AXESSO_URL = "http://api-prd.axesso.de/amz/amazon-lookup-product?advancedProxy=true&url=";
    private static final String API_KEY = "6486680f-b86c-4409-864e-83865516896d";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompareResponse get(@QueryParam("product_url") String product_url) {
        CompareResponse compareResponse = new CompareResponse();
        if (product_url == null || product_url.isEmpty()) {
            compareResponse.setErrorResponse("Please input an amazon url or product number");
            return compareResponse;
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().header("axesso-api-key", API_KEY)
                .uri(URI.create(AXESSO_URL + product_url)).build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<AmazonProduct> amazonProducts = new ArrayList<>();
            AmazonProduct first_product = ResponseParser.getAmazonProduct(response);

            amazonProducts.add(first_product);
            compareResponse.setAmazonProducts(amazonProducts);
            return compareResponse;

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            compareResponse.setErrorResponse("Something went wrong. Try again later");
            return compareResponse;
        }  catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            compareResponse.setErrorResponse("Something went wrong. Try again later");
            return compareResponse;
        }
    }
}
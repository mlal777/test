package com.app.compare;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/compare")
public class Compare {

    private static final String AXESSO_URL = "http://api-prd.axesso.de/amz/amazon-lookup-product?url=";
    private static final String AMAZON_URL_PREFIX = "https://www.amazon.com/dp/";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("product_url") String product_url) {
        if (product_url == null || product_url.isEmpty()) {
            return "Please input an amazon url or product number";
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().header("axesso-api-key", "6486680f-b86c-4409-864e-83865516896d")
                .uri(URI.create(AXESSO_URL + product_url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().toString();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Unable to return value";
        }  catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Unable to return value";
        }
    }
}
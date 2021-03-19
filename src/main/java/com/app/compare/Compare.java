package com.app.compare;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/compare")
public class Compare {

    @GET
    public String get() {
        return "Compare";
    }
}
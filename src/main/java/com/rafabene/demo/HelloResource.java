package com.rafabene.demo;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/")
@ApplicationScoped
public class HelloResource {

    private boolean fail;
    private int count;

    @GET
    public Response hello(){
        String host = System.getenv("HOSTNAME");
        if (fail){
            return Response.status(Status.SERVICE_UNAVAILABLE)
                .entity("FAILS(503) from " + host + " - " + count++).build();
        }else{
            String message = "hello from " + host + " - " + count++;
            return Response.ok(message).build();
        }
    }

    @GET
    @Path("/fail")
    public Response fail(){
        fail=true;
        return Response.ok("Following requests to '/' will return a 503").build();
    }

    @GET
    @Path("/fix")
    public Response fix(){
        fail=false;
        return Response.ok("Following requests to '/' will return a 200").build();
    }
}
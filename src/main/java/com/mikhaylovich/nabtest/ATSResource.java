package com.mikhaylovich.nabtest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ats")
public class ATSResource {
//
//  @Inject
//  @Named("test.var")
//  private String value;

    //@Produces(value = "application/json")
    @GET
    @Path("/page")
    public Response getStatus() {
        return Response.status(Response.Status.BAD_REQUEST).entity("123").build();
    }

    @POST
    @Path("/test")
    public Response getTest() {
        return Response.status(Response.Status.FORBIDDEN).entity("456").build();
    }

}

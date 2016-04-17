package com.mikhaylovich.nabtest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/ats")
public class ATSResource {
//
//  @Inject
//  @Named("test.var")
//  private String value;


    @GET
    @Path("/json")
    @Produces(value = "application/json")
    public Response getStatus() {
        Person person = new Person("Dima", "+79253550905");
        String personJson = JsonMapper.convertToJson(person);
        return Response.ok(personJson).build();
    }


}

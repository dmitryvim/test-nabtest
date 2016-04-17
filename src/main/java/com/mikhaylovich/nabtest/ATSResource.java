package com.mikhaylovich.nabtest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/ats")
public class ATSResource {

    /**
     * Значения прописываются в файле settings.properties
     */
    @Inject
    @Named("head.name")
    private String head_name;

    /**
     * Значения прописываются в файле settings.properties
     */
    @Inject
    @Named("head.phone")
    private String head_phone;



    @GET
    @Path("/json")
    @Produces(value = "application/json")
    public Response getJson() {
        Person person = new Person("Dima", "+79253550905");
        String personJson = JsonMapper.convertToJson(person);
        return Response.ok(personJson).build();
    }

    @GET
    @Path("/named")
    @Produces(value = "application/json")
    public Response getNamed() {
        Person head = new Person(this.head_name, this.head_phone);
        String personJson = JsonMapper.convertToJson(head);
        return Response.ok(personJson).build();
    }
}

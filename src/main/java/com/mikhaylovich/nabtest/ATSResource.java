package com.mikhaylovich.nabtest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/test")
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

    @Inject
    private InterfaceService1 service1;

    @Inject
    private Service2 service2;



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

    @GET
    @Path("/inject/interface")
    public Response getInjectedInterface() {
        Person ii = this.service1.getPerson();
        String iiJson = JsonMapper.convertToJson(ii);
        return Response.ok(iiJson).build();
    }

    @GET
    @Path("/inject/class")
    public Response getInjectedClass() {
        return Response.ok(this.service2.getPersonJson()).build();
    }

    @GET
    @Path("/name/{name}/phone/{phone}")
    public Response getPersonFromString(@PathParam("name") String name, @PathParam("phone") String phone) {
        Person person = new Person(name, phone);
        String personJson = JsonMapper.convertToJson(person);
        return Response.ok(personJson).build();
    }
}

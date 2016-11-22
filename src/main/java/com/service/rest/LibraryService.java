package com.service.rest;

import com.service.manipulations.ResponseBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Olha_Pidhorna on 7/20/2016.
 */
@Path("/library")
public class LibraryService {

    private ResponseBuilder responseBuilder;

    public LibraryService() {
        responseBuilder = new ResponseBuilder();
    }

    @GET
    @Path("/books")
    @Produces("application/json")
    public Response getAllBooks() {
        return responseBuilder.getAll();
    }

    @GET
    @Path("{id}/book")
    @Produces("application/json")
    public Response getOne(@PathParam("id") int id) {
        return responseBuilder.getOne(id);
    }

    @POST
    @Path("/book")
    @Consumes("text/plain")
    @Produces("application/json")
    public Response setOne(String id) {
        return responseBuilder.setOne(Integer.parseInt(id));
    }

    @POST
    @Path("/change")
    @Produces("application/json")
    @Consumes("text/plain")
    public Response changeOne(String ids) {
        String[] idArr = ids.split(",");
        return responseBuilder.changeOne(Integer.parseInt(idArr[0]), Integer.parseInt(idArr[1]));
    }

    @GET
    @Path("{autorId}/books-autor")
    @Produces("application/json")
    public Response getAllBooks(@PathParam("autorId") int autorId) {
        return responseBuilder.getById(autorId);
    }
}

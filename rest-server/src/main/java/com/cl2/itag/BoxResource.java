package com.cl2.itag;

import com.cl2.itag.model.Box;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;


@Path("box")
@Singleton
public class BoxResource {

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "test";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create/{input}")
    public Response put(@PathParam("input") String input) {
        Response response;
        ObjectMapper mapper = new ObjectMapper();
        Box inputBox = null;

        try {
            inputBox = mapper.readValue(input, Box.class);
        } catch (IOException e) {
            System.err.println("erreur lors de la deserialization");
        }

        URI uri = uriInfo.getAbsolutePath();
        if (inputBox != null && inputBox.getId() != 0) {
            response = Response.created(uri).entity(inputBox).build();
        } else {
            response = Response.noContent().build();
        }

        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/edit")
    public Response edit(@FormParam("input") String input) {
        Response response;
        ObjectMapper mapper = new ObjectMapper();
        Box inputBox = null;

        try {
            inputBox = mapper.readValue(input, Box.class);
        } catch (IOException e) {
            System.err.println("erreur lors de la deserialization");
        }

        if (inputBox != null && inputBox.getId() != 0 && inputBox.getId() == 12) {
            response = Response.ok().entity(inputBox).build();
        } else {
            response = Response.noContent().build();
        }

        return response;
    }


}

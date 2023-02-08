package com.tsswebapps.cliente;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> get(){
        return Cliente.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@QueryParam("id") long id){
        return Cliente.findById(id);
    }

    @DELETE
    @Path("deleteById")
    @Transactional
    public void deleteById(@QueryParam("id") long id){
        Cliente.deleteById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newCliente(Cliente cliente){
        cliente.id = null;
        cliente.persist();

        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}

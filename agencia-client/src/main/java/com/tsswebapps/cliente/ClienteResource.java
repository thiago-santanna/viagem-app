package com.tsswebapps.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/cliente-cli")
public class ClienteResource {
    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("newCliente")
    public Response testaNewCliente() {
        Cliente cliente = Cliente.of(99, "Remoto 01");
        Response response = clienteService.newCliente(cliente);
        System.out.println("cliente");

        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}

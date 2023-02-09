package com.tsswebapps.reserva;

import com.tsswebapps.cliente.Cliente;
import com.tsswebapps.cliente.ClienteService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reserva-cli")
public class ReservaResource {
    @Inject
    @RestClient
    ReservaService reservaService;

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newReserva")
    public String testaNewReserva(){
        Cliente cliente = clienteService.findById(1);
        Reserva reserva = Reserva.of(cliente);
        String response = reservaService.testaNewReserva(reserva);
        return response;
    }
}

package com.tsswebapps.reserva;

import com.tsswebapps.cliente.Cliente;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080/reserva")
public interface ReservaService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String testaNewReserva(Reserva reserva);
}

package org.acme.kafka.producer;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Multi;

@Path("/quotes")
public class QuotesResource {

    @Channel("quote-requests")
    Emitter<String> quoteRequestEmitter;


    @POST
    @Path("/request/modelM")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequestM() {
        String name = "Tesla - model M";
        quoteRequestEmitter.send(name);
        return name;
    }

    @POST
    @Path("/request/modelI")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequestI()  {
        String name = "Tesla - model I";
        quoteRequestEmitter.send(name);
        return name;
    }

    @POST
    @Path("/request/delivered")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequestDelivred()  {
        String name = "Tout vos vehicules sont prêts à être délivrés";
        quoteRequestEmitter.send(name);
        return name;
    }

    @POST
    @Path("/request/sold")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequestSold() throws InterruptedException {
        String name = "Ce lot de véhicules est Vendu !!!";
        quoteRequestEmitter.send(name);
        Thread.sleep(2000);
        return name;
    }

    @Channel("quotes")
    Multi<Quote> quotes;


    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS) // denotes that server side events (SSE) will be produced
    public Multi<Quote> stream() {
        return quotes.log();
    }
}

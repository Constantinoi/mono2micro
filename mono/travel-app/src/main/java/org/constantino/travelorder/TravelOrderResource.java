package org.constantino.travelorder;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("orders")
public class TravelOrderResource {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    //localhost:8080/orders/
    public List<TravelOrder> orders() {
        return TravelOrder.listAll();
    }

    @GET
    @Path("id")
    //localhost:8080/orders/id?id=1
    public TravelOrder findById(@QueryParam("id") long id) {
        return TravelOrder.findById(id);
    }

    @Transactional//deve nota com transacional para persist
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    //curl -d "{}" -H "Content-Type: application/json" localhost:8080/orders
    public TravelOrder newTravelOrder(TravelOrder order) {
        order.id = null;
        order.persist();
        return order;
    }


}

package org.constantino.hotel;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.constantino.travelorder.TravelOrder;

import java.util.List;

@Path("hotel")
public class HotelResource {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    //localhost:8080/hotel/
    public List<Hotel> hotel() {
        return Hotel.listAll();
    }

    @GET
    @Path("id")
    //localhost:8080/hotel/id?id=1
    public Hotel findById(@QueryParam("id") long id) {
        return Hotel.findById(id);
    }

    @GET
    @Path("findByTravelOrderId")
    //localhost:8080/hotel/id?id=1
    public Hotel findByTravelOrderId(@QueryParam("id") long travelOrderId) {
        return Hotel.findByTravelOrderId(travelOrderId);
    }

    @Transactional//deve nota com transacional para persist
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    //curl -d "{}" -H "Content-Type: application/json" localhost:8080/hotel
    public Hotel newHotel(Hotel hotel) {
        hotel.id = null;
        hotel.persist();
        return hotel;
    }
}

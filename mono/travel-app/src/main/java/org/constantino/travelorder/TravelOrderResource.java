package org.constantino.travelorder;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.constantino.flight.Flight;
import org.constantino.flight.FlightResource;
import org.constantino.hotel.Hotel;
import org.constantino.hotel.HotelResource;

import java.util.List;


@Path("orders")
public class TravelOrderResource {

    @Inject
    FlightResource flightResource;

    @Inject
    HotelResource hotelResource;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    //curl localhost:8080/orders/
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
    public TravelOrder newTravelOrder(TravelOrderDTO orderDTO) {
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.travelOrderId = order.id;
        flight.fromAirport = orderDTO.getFromAirport();
        flight.toAirport = orderDTO.getToAirport();
        flightResource.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.nights= orderDTO.getNights();
        hotel.travelOrderId = order.id;
        hotelResource.newHotel(hotel);

        return order;
    }


}

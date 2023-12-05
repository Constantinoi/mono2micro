package org.constantino.hotel;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import org.constantino.flight.Flight;

@Entity
public class Hotel extends PanacheEntity {

    public Long travelOrderId;
    public Integer nights;


    public static Hotel findByTravelOrderId(long travelOrderId){
        return find("travelorderid",travelOrderId).firstResult();
    }
}

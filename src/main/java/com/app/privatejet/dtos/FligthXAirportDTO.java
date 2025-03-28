package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Airport;
import com.app.privatejet.modelos.Fligth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class FligthXAirportDTO {

    private String id;
    private Fligth fligth;
    private Airport departure_airport;
    private Airport arrival_airport;

    public FligthXAirportDTO(String id, Fligth fligth, Airport departure_airport, Airport arrival_airport) {
        this.id = id;
        this.fligth = fligth;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Fligth getFligth() {
        return fligth;
    }

    public void setFligth(Fligth fligth) {
        this.fligth = fligth;
    }

    public Airport getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(Airport departure_airport) {
        this.departure_airport = departure_airport;
    }

    public Airport getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(Airport arrival_airport) {
        this.arrival_airport = arrival_airport;
    }
}

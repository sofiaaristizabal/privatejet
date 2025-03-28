package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Airport;
import com.app.privatejet.modelos.Fligth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class FligthXAirportDTO {

    private String id;
    private String fligth_id;
    private String departure_airport_id;
    private String arrival_airport_id;

    public FligthXAirportDTO(String id, String fligth_id, String departure_airport_id, String arrival_airport_id) {
        this.id = id;
        this.fligth_id = fligth_id;
        this.departure_airport_id = departure_airport_id;
        this.arrival_airport_id = arrival_airport_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFligth_id() {
        return fligth_id;
    }

    public void setFligth_id(String fligth_id) {
        this.fligth_id = fligth_id;
    }

    public String getDeparture_airport_id() {
        return departure_airport_id;
    }

    public void setDeparture_airport_id(String departure_airport_id) {
        this.departure_airport_id = departure_airport_id;
    }

    public String getArrival_airport_id() {
        return arrival_airport_id;
    }

    public void setArrival_airport_id(String arrival_airport_id) {
        this.arrival_airport_id = arrival_airport_id;
    }
}

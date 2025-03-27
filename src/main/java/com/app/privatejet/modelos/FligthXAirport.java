package com.app.privatejet.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name="FligthXAirport")
public class FligthXAirport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "fligth_id", nullable = false)
    private Fligth fligth;

    @ManyToOne
    @JoinColumn(name = "departure_airport", nullable = false)
    private Airport departure_airport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport", nullable = false)
    private Airport arrival_airport;

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

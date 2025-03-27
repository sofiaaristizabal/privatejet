package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Celebrity;
import com.app.privatejet.modelos.PrivateJet;
import com.app.privatejet.modelos.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class FligthDTO {

    private String id;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private Purpose purpose;
    private Celebrity celebrity;
    private PrivateJet privateJet;

    public FligthDTO(String id, Timestamp departure_time, Timestamp arrival_time, Purpose purpose, Celebrity celebrity, PrivateJet privateJet) {
        this.id = id;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.purpose = purpose;
        this.celebrity = celebrity;
        this.privateJet = privateJet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Timestamp departure_time) {
        this.departure_time = departure_time;
    }

    public Timestamp getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Timestamp arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    public PrivateJet getPrivateJet() {
        return privateJet;
    }

    public void setPrivateJet(PrivateJet privateJet) {
        this.privateJet = privateJet;
    }
}

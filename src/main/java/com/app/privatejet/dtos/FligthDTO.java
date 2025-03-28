package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Celebrity;
import com.app.privatejet.modelos.PrivateJet;
import com.app.privatejet.modelos.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data

public class FligthDTO {

    private String id;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private Purpose purpose;
    private String celebrity_id;
    private String privateJet_id;

    public FligthDTO(String id, Timestamp departure_time, Timestamp arrival_time, Purpose purpose, String celebrity_id, String privateJet_id) {
        this.id = id;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.purpose = purpose;
        this.celebrity_id = celebrity_id;
        this.privateJet_id = privateJet_id;
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

    public String getCelebrity_id() {
        return celebrity_id;
    }

    public void setCelebrity_id(String celebrity) {
        this.celebrity_id = celebrity_id;
    }

    public String getPrivateJet_id() {
        return privateJet_id;
    }

    public void setPrivateJet(String privateJet) {
        this.privateJet_id = privateJet_id;
    }
}

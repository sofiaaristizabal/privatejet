package com.app.privatejet.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name="Fligth")
public class Fligth {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Getter
    @Column(nullable = false)
    private Timestamp departure_time;

    @Getter
    @Column(nullable = false)
    private Timestamp arrival_time;

    @Getter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    @Getter
    @ManyToOne
    @JoinColumn(name = "celebrity_id", nullable = false)
    private Celebrity celebrity;

    @ManyToOne
    @JoinColumn(name = "privateJet_id", nullable = false)
    private PrivateJet privateJet;


    public void setId(String id) {
        this.id = id;
    }

    public void setDeparture_time(Timestamp departure_time) {
        this.departure_time = departure_time;
    }

    public void setArrival_time(Timestamp arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    public String getId() {
        return id;
    }

    public Timestamp getDeparture_time() {
        return departure_time;
    }

    public Timestamp getArrival_time() {
        return arrival_time;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public PrivateJet getPrivateJet() {
        return privateJet;
    }

    public void setPrivateJet(PrivateJet privateJet) {
        this.privateJet = privateJet;
    }
}

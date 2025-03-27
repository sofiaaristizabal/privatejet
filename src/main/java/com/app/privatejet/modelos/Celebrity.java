package com.app.privatejet.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name="Celebrity")
public class Celebrity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String profession;

    @Column()
    private double net_worth;

    @Column()
    private boolean suspicious_activity = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(double net_worth) {
        this.net_worth = net_worth;
    }

    public boolean isSuspicious_activity() {
        return suspicious_activity;
    }

    public void setSuspicious_activity(boolean suspicious_activity) {
        this.suspicious_activity = suspicious_activity;
    }
}

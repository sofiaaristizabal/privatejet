package com.app.privatejet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CelebrityDTO {

    private String id;
    private String name;
    private String profession;
    private double net_worth;
    private boolean suspicious_activity;

    public CelebrityDTO(String id, String name, String profession, double net_worth, boolean suspicious_activity) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.net_worth = net_worth;
        this.suspicious_activity = suspicious_activity;
    }

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

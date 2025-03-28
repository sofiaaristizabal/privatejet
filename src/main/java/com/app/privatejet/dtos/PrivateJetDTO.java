package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Celebrity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class PrivateJetDTO {

    private String id;
    private String model;
    private int capacity;
    private Celebrity celebrity;

    public PrivateJetDTO(String id, String model, int capacity, Celebrity celebrity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
        this.celebrity = celebrity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }
}

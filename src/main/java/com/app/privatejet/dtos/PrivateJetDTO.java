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
    private String celebrity_id;

    public PrivateJetDTO(String id, String model, int capacity, String celebrity_id) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
        this.celebrity_id = celebrity_id;
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

    public String getCelebrity_id() {
        return celebrity_id;
    }

    public void setCelebrity_id(String celebrity_id) {
        this.celebrity_id = celebrity_id;
    }
}

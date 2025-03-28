package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Fligth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class SecurityReportDTO {

    private String id;
    private Fligth fligth;
    private String reported_by;
    private String description;
    private boolean is_resolved;

    public SecurityReportDTO(String id, Fligth fligth, String reported_by, String description, boolean is_resolved) {
        this.id = id;
        this.fligth = fligth;
        this.reported_by = reported_by;
        this.description = description;
        this.is_resolved = is_resolved;
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

    public String getReported_by() {
        return reported_by;
    }

    public void setReported_by(String reported_by) {
        this.reported_by = reported_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_resolved() {
        return is_resolved;
    }

    public void setIs_resolved(boolean is_resolved) {
        this.is_resolved = is_resolved;
    }
}

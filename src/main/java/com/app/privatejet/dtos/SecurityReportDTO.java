package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Fligth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class SecurityReportDTO {

    private String id;
    private String fligth_id;
    private String reported_by;
    private String description;
    private boolean is_resolved;

    public SecurityReportDTO(String id, String fligth_id, String reported_by, String description, boolean is_resolved) {
        this.id = id;
        this.fligth_id = fligth_id;
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

    public String getFligth_id() {
        return fligth_id;
    }

    public void setFligth_id(String fligth_id) {
        this.fligth_id = fligth_id;
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

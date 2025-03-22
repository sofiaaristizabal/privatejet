package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Fligth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityReportDTO {

    private String id;
    private Fligth fligth;
    private String reported_by;
    private String description;
    private boolean is_resolved;
}

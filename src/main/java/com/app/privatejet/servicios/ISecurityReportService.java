package com.app.privatejet.servicios;

import com.app.privatejet.dtos.SecurityReportDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface ISecurityReportService {

    public SecurityReportDTO addSecurityReport(@Valid SecurityReportDTO securityReportDTO);
    public List<SecurityReportDTO> getSecurityReports();
    public Optional<SecurityReportDTO> getSecurityReportById(String id);
    public void deleteSecurityReportById(String id);

}

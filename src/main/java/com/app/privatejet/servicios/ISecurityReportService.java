package com.app.privatejet.servicios;

import com.app.privatejet.dtos.SecurityReportDTO;

import java.util.List;
import java.util.Optional;

public interface ISecurityReportService {

    public SecurityReportDTO addSecurityReport(SecurityReportDTO securityReportDTO);
    public List<SecurityReportDTO> getSecurityReports();
    public Optional<SecurityReportDTO> getSecurityReportById(String id);
    public Optional<SecurityReportDTO> getSecurityReportByName(String name);
    public void deleteSecurityReportById(String id);

}

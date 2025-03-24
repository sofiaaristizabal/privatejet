package com.app.privatejet.servicios;

import com.app.privatejet.dtos.SecurityReportDTO;
import com.app.privatejet.modelos.SecurityReport;
import com.app.privatejet.repositorios.ISecurityReportRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class SecurityReportService implements ISecurityReportService{

    @Autowired
    private ISecurityReportRepository securityReportRepository;

    @Override
    public SecurityReportDTO addSecurityReport(@Valid SecurityReportDTO securityReportDTO) {

        SecurityReport securityReport = new SecurityReport();
        securityReport.setFligth(securityReportDTO.getFligth());
        securityReport.setReported_by(securityReportDTO.getReported_by());
        securityReport.setDescription(securityReportDTO.getDescription());
        securityReport.set_resolved(securityReportDTO.is_resolved());

        securityReport = securityReportRepository.save(securityReport);

        return convertirADTO(securityReport);
    }

    @Override
    public List<SecurityReportDTO> getSecurityReports() {

        return securityReportRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public Optional<SecurityReportDTO> getSecurityReportById(String id) {

        if(!securityReportRepository.existsById(id)){
            throw new EntityNotFoundException("Security report with id" + id + " not found");
        }
        return securityReportRepository.findById(id).map(this::convertirADTO);
    }


    @Override
    public void deleteSecurityReportById(String id) {

        if(!securityReportRepository.existsById(id)){
            throw new EntityNotFoundException("Security report with id" + id + " not found");
        }

        securityReportRepository.deleteById(id);
    }

    private SecurityReportDTO convertirADTO( SecurityReport securityReport){
        return new SecurityReportDTO(
                securityReport.getId(),
                securityReport.getFligth(),
                securityReport.getReported_by(),
                securityReport.getDescription(),
                securityReport.is_resolved()
        );
    }
}

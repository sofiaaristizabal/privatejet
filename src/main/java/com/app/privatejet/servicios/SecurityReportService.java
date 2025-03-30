package com.app.privatejet.servicios;

import com.app.privatejet.dtos.SecurityReportDTO;
import com.app.privatejet.modelos.SecurityReport;
import com.app.privatejet.repositorios.IFligthRepository;
import com.app.privatejet.repositorios.ISecurityReportRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    private IFligthRepository fligthRepository;

    @Override
    @CacheEvict(value = {"securityReports", "securityReport"}, allEntries = true)
    public SecurityReportDTO addSecurityReport(@Valid SecurityReportDTO securityReportDTO) {

        SecurityReport securityReport = new SecurityReport();
        securityReport.setFligth(
                fligthRepository.findById(securityReportDTO.getFligth_id()).orElseThrow(() -> new EntityNotFoundException("Fligth not found with id: " + securityReportDTO.getFligth_id()))
        );
        securityReport.setReported_by(securityReportDTO.getReported_by());
        securityReport.setDescription(securityReportDTO.getDescription());
        securityReport.setIs_resolved(securityReportDTO.is_resolved());

        securityReport = securityReportRepository.save(securityReport);

        return convertirADTO(securityReport);
    }

    @Override
    @Cacheable(value = "securityReports")
    public List<SecurityReportDTO> getSecurityReports() {

        return securityReportRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "securityReport", key = "#id")
    public Optional<SecurityReportDTO> getSecurityReportById(String id) {

        if(!securityReportRepository.existsById(id)){
            throw new EntityNotFoundException("Security report with id" + id + " not found");
        }
        return securityReportRepository.findById(id).map(this::convertirADTO);
    }

    @Override
    @CachePut(value="airport", key="#id")
    @CacheEvict(value = "airports", allEntries = true)
    public SecurityReportDTO updateSecurityReport(String id, SecurityReportDTO securityReportDTO) {
        return securityReportRepository.findById(id).map(
                securityReport -> {
                    securityReport.setReported_by(securityReportDTO.getReported_by());
                    securityReport.setDescription(securityReportDTO.getDescription());
                    securityReport.setIs_resolved(securityReportDTO.is_resolved());
                    securityReport.setFligth(fligthRepository.findById(securityReportDTO.getFligth_id()).orElseThrow(() -> new EntityNotFoundException("Fligth not found with id: " + securityReportDTO.getFligth_id())));

                    return convertirADTO(securityReportRepository.save(securityReport));
                }
        ).orElseThrow(() -> new RuntimeException("security report not found"));
    }


    @Override
    @CacheEvict(value = {"airport", "airports"}, key = "#id", allEntries = true)
    public void deleteSecurityReportById(String id) {

        if(!securityReportRepository.existsById(id)){
            throw new EntityNotFoundException("Security report with id" + id + " not found");
        }

        securityReportRepository.deleteById(id);
    }

    private SecurityReportDTO convertirADTO( SecurityReport securityReport){
        return new SecurityReportDTO(
                securityReport.getId(),
                securityReport.getFligth().getId(),
                securityReport.getReported_by(),
                securityReport.getDescription(),
                securityReport.is_resolved()
        );
    }
}

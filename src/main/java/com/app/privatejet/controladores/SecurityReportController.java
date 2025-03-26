package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.SecurityReportDTO;
import com.app.privatejet.repositorios.ISecurityReportRepository;
import com.app.privatejet.servicios.ISecurityReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/securityReport")
public class SecurityReportController {

    @Autowired
    private ISecurityReportService securityReportService;

    @GetMapping("/")
    public ResponseEntity<List<SecurityReportDTO>> getSecurityReports(){

        return ResponseEntity.ok(securityReportService.getSecurityReports());
    }

    @PostMapping("/")
    public ResponseEntity<SecurityReportDTO> createSecurityReport(@Valid @RequestBody SecurityReportDTO securityReportDTO) {

        SecurityReportDTO newSecurityReport = securityReportService.addSecurityReport(securityReportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSecurityReport);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<SecurityReportDTO>> findSecurityReportById(@PathVariable String id){
        return ResponseEntity.ok(securityReportService.getSecurityReportById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecurityReport(@PathVariable String id){
        securityReportService.deleteSecurityReportById(id);
        return ResponseEntity.noContent().build();
    }

}

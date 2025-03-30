package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.SecurityReportDTO;
import com.app.privatejet.repositorios.ISecurityReportRepository;
import com.app.privatejet.servicios.ISecurityReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/securityReport")
@Tag(name = "Security Report controller", description = "Manage security report operations" )
public class SecurityReportController {

    @Autowired
    private ISecurityReportService securityReportService;

    @GetMapping("/")
    @Operation(summary = "Get security reports", description = "Retrieves a list of all security reports.")
    public ResponseEntity<List<SecurityReportDTO>> getSecurityReports(){

        return ResponseEntity.ok(securityReportService.getSecurityReports());
    }

    @PostMapping("/")
    @Operation(summary = "security report", description = "Add a new security report to the repository")
    public ResponseEntity<SecurityReportDTO> createSecurityReport(@Valid @RequestBody SecurityReportDTO securityReportDTO) {

        SecurityReportDTO newSecurityReport = securityReportService.addSecurityReport(securityReportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSecurityReport);
    }

    @GetMapping("/findId/{id}")
    @Operation(summary = "find security report by Id", description = "find a security report from the repository by it's Id")
    public ResponseEntity<Optional<SecurityReportDTO>> findSecurityReportById(@PathVariable String id){
        return ResponseEntity.ok(securityReportService.getSecurityReportById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a security report", description = "Delete a security report by it's Id from repository")
    public ResponseEntity<Void> deleteSecurityReport(@PathVariable String id){
        securityReportService.deleteSecurityReportById(id);
        return ResponseEntity.noContent().build();
    }

}

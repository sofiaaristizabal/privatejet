package com.app.privatejet.repositorios;

import com.app.privatejet.modelos.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISecurityReportRepository extends JpaRepository<SecurityReport, String> {

    public SecurityReport save(SecurityReport securityReport);
    public Optional<SecurityReport> findById(String id);
    public List<SecurityReport> findAll();
    public void deleteById(String id);

}

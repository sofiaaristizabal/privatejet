package com.app.privatejet.repositorios;

import com.app.privatejet.modelos.FligthXAirport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IFligthXAirportRepository extends JpaRepository<FligthXAirport, String> {

    public FligthXAirport save(FligthXAirport fligthXAirport);
    public Optional<FligthXAirport> findById(String Id);
    public List<FligthXAirport> findAll();
    public void deleteById(String id);



}

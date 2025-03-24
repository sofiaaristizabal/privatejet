package com.app.privatejet.repositorios;

import com.app.privatejet.modelos.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAirportRepository extends JpaRepository<Airport, String> {

    public Airport save(Airport airport);

    public Optional<Airport> findById (String id);

    public List<Airport> findAll();

    public void deleteById(String id);

    public Optional<Airport> findByName(String name);

    public boolean existsByName(String name);

}

package com.app.privatejet.servicios;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.modelos.Airport;
import com.app.privatejet.repositorios.IAirportRepository;
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
public class AirportService implements IAirportService{

    @Autowired
    private IAirportRepository airportRepository;
    @Override
    @CacheEvict(value = {"airports", "airport"}, allEntries = true)
    public AirportDTO addAirport(@Valid AirportDTO airportDTO) {

        Airport airport = new Airport();
        airport.setName(airportDTO.getName());
        airport.setLocation(airportDTO.getLocation());
        airport.setCapacity(airportDTO.getCapacity());
        airport.setOwners(airportDTO.getOwners());

        airport = airportRepository.save(airport);

        return convertirADTO(airport);

    }

    @Override
    @Cacheable(value = "airports")
    public List<AirportDTO> getAirports() {
        return airportRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "airport", key = "#id")
    public Optional<AirportDTO> getAirportById(String id) {
        if (!airportRepository.existsById(id)) {
            throw new EntityNotFoundException("Airport with ID " + id + " not found.");
        }
        return airportRepository.findById(id).map(this::convertirADTO);
    }

    @Override
    @Cacheable(value = "airport", key = "#name")
    public Optional<AirportDTO> getAirportByName(String name) {
        if (!airportRepository.existsByName(name)) {
            throw new EntityNotFoundException("Airport with name " + name + " not found.");
        }
        return airportRepository.findByName(name).map(this::convertirADTO);
    }

    @Override
    @CachePut(value="airport", key="#id")
    @CacheEvict(value = "airports", allEntries = true)
    public AirportDTO updateAirport(String id, AirportDTO airportDTO) {
        return airportRepository.findById(id).map(
                airport ->{
                    airport.setLocation(airportDTO.getLocation());
                    airport.setCapacity(airportDTO.getCapacity());
                    airport.setName(airportDTO.getName());
                    airport.setOwners(airportDTO.getOwners());
                    return convertirADTO(airportRepository.save(airport));
                }
        ).orElseThrow(() -> new RuntimeException("airport not found"));
    }

    @Override
    @CacheEvict(value = {"airport", "airports"}, key = "#id", allEntries = true)
    public void deleteAirportById(String id) {

        if (!airportRepository.existsById(id)) {
            throw new EntityNotFoundException("Airport with ID " + id + " not found.");
        }
        airportRepository.deleteById(id);
    }

    private AirportDTO convertirADTO(Airport airport){

        return new AirportDTO(
                airport.getId(),
                airport.getName(),
                airport.getLocation(),
                airport.getCapacity(),
                airport.getOwners()
        );
    }
}

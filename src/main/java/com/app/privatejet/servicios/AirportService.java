package com.app.privatejet.servicios;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.modelos.Airport;
import com.app.privatejet.repositorios.IAirportRepository;
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
public class AirportService implements IAirportService{

    @Autowired
    private IAirportRepository airportRepository;
    @Override
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
    public List<AirportDTO> getAirports() {
        return airportRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AirportDTO> getAirportById(String id) {
        if (!airportRepository.existsById(id)) {
            throw new EntityNotFoundException("Airport with ID " + id + " not found.");
        }
        return airportRepository.findById(id).map(this::convertirADTO);
    }

    @Override
    public Optional<AirportDTO> getAirportByName(String Name) {
        if (!airportRepository.existsByName(Name)) {
            throw new EntityNotFoundException("Airport with name " + Name + " not found.");
        }
        return airportRepository.findByName(Name).map(this::convertirADTO);
    }

    @Override
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

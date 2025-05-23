package com.app.privatejet.servicios;

import com.app.privatejet.dtos.AirportDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IAirportService {

    public AirportDTO addAirport(@Valid AirportDTO airportDTO);
    public List<AirportDTO> getAirports();
    public Optional<AirportDTO> getAirportById(String id);
    public Optional<AirportDTO> getAirportByName(String Name);

    public AirportDTO updateAirport (String id, AirportDTO airportDTO);
    public void deleteAirportById(String id);


}

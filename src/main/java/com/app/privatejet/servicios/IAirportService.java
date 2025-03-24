package com.app.privatejet.servicios;

import com.app.privatejet.dtos.AirportDTO;

import java.util.List;
import java.util.Optional;

public interface IAirportService {

    public AirportDTO addAirport(AirportDTO airportDTO);
    public List<AirportDTO> getAirports();
    public Optional<AirportDTO> getAirportById(String id);
    public Optional<AirportDTO> getAirportByName(String Name);
    public void deleteAirportById(String id);


}

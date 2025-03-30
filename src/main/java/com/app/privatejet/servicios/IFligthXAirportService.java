package com.app.privatejet.servicios;

import com.app.privatejet.dtos.FligthXAirportDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IFligthXAirportService {

    public FligthXAirportDTO addFligthXAirport(@Valid FligthXAirportDTO fligthXAirportDTO);
    public List<FligthXAirportDTO> getFligthXAirport();
    public Optional<FligthXAirportDTO> getFligthXAirportById(String Id);
    public FligthXAirportDTO updateFligthXAirport(String id, FligthXAirportDTO fligthXAirportDTO);
    public void deleteFligthXAirportById(String id);

}

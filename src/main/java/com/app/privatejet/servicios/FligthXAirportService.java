package com.app.privatejet.servicios;

import com.app.privatejet.dtos.FligthXAirportDTO;
import com.app.privatejet.modelos.FligthXAirport;
import com.app.privatejet.repositorios.IAirportRepository;
import com.app.privatejet.repositorios.IFligthRepository;
import com.app.privatejet.repositorios.IFligthXAirportRepository;
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
public class FligthXAirportService implements IFligthXAirportService{

    @Autowired
    private IFligthXAirportRepository fligthXAirportRepository;

    @Autowired
    private IFligthRepository fligthRepository;

    @Autowired
    private IAirportRepository airportRepository;

    @Override
    public FligthXAirportDTO addFligthXAirport(@Valid FligthXAirportDTO fligthXAirportDTO) {

        FligthXAirport fligthXAirport = new FligthXAirport();
        fligthXAirport.setFligth(
                fligthRepository.findById(fligthXAirportDTO.getFligth_id()).orElseThrow(() -> new EntityNotFoundException("Flight not found with id: " + fligthXAirportDTO.getFligth_id()))
        );
        fligthXAirport.setDeparture_airport(
                airportRepository.findById(fligthXAirportDTO.getDeparture_airport_id()).orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + fligthXAirportDTO.getDeparture_airport_id()))
        );
        fligthXAirport.setArrival_airport(
                airportRepository.findById(fligthXAirportDTO.getArrival_airport_id()).orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + fligthXAirportDTO.getDeparture_airport_id()))
        );

        fligthXAirport = fligthXAirportRepository.save(fligthXAirport);

        return convertirADTO(fligthXAirport);
    }

    @Override
    public List<FligthXAirportDTO> getFligthXAirport() {
        return fligthXAirportRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public Optional<FligthXAirportDTO> getFligthXAirportById(String Id) {

        if(!fligthXAirportRepository.existsById(Id)){
            throw new EntityNotFoundException("FligthXAirport with Id " + Id + "was not found");
        }

        return fligthXAirportRepository.findById(Id).map(this::convertirADTO);
    }

    @Override
    public void deleteFligthXAirportById(String id) {

        if(!fligthXAirportRepository.existsById(id)){
            throw new EntityNotFoundException("FligthXAirport with Id " + id + "was not found");
        }

        fligthXAirportRepository.deleteById(id);
    }

    private FligthXAirportDTO convertirADTO(FligthXAirport fligthXAirport){

        return new FligthXAirportDTO(
                fligthXAirport.getId(),
                fligthXAirport.getFligth().getId(),
                fligthXAirport.getDeparture_airport().getId(),
                fligthXAirport.getArrival_airport().getId()
        );
    }
}

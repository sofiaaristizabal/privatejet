package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.servicios.IAirportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @GetMapping("/")
    public ResponseEntity<List<AirportDTO>> getAirports(){

        return ResponseEntity.ok(airportService.getAirports());
    }

    @PostMapping("/")
    public ResponseEntity<AirportDTO> createAirport(@Valid @RequestBody AirportDTO airportDTO) {

        AirportDTO newAirport = airportService.addAirport(airportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAirport);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<AirportDTO>> findAirportById(@PathVariable String id){
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<Optional<AirportDTO>> findAirportByName(@PathVariable String name){
        return ResponseEntity.ok(airportService.getAirportByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String id){
        airportService.deleteAirportById(id);
        return ResponseEntity.noContent().build();
    }

}

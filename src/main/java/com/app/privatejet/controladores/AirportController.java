package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.servicios.IAirportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airport")
@Tag(name = "Airport controller", description = "Manage airport operations" )
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @GetMapping("/")
    @Operation(summary = "Get an airport", description = "Retrieves a list of all airports.")
    public ResponseEntity<List<AirportDTO>> getAirports(){

        return ResponseEntity.ok(airportService.getAirports());
    }

    @PostMapping("/")
    @Operation(summary = "Create an airport", description = "Add a new airport to the repository")
    public ResponseEntity<AirportDTO> createAirport(@Valid @RequestBody AirportDTO airportDTO) {

        AirportDTO newAirport = airportService.addAirport(airportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAirport);
    }

    @GetMapping("/findId/{id}")
    @Operation(summary = "find airport by Id", description = "find an airport from the repository by it's Id")
    public ResponseEntity<Optional<AirportDTO>> findAirportById(@PathVariable String id){
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @GetMapping("/findName/{name}")
    @Operation(summary = "Find and airport by name", description = "Find an airport from the repository by its name")
    public ResponseEntity<Optional<AirportDTO>> findAirportByName(@PathVariable String name){
        return ResponseEntity.ok(airportService.getAirportByName(name));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete an airport", description = "Delete an airport by it's Id from repository")
    public ResponseEntity<Void> deleteAirport(@PathVariable String id){
        airportService.deleteAirportById(id);
        return ResponseEntity.noContent().build();
    }

}

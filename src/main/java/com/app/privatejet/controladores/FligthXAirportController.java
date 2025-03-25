package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.FligthXAirportDTO;
import com.app.privatejet.servicios.IFligthXAirportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/FligthXAirport")
public class FligthXAirportController {

    @Autowired
    private IFligthXAirportService fligthXAirportService;

    @GetMapping("/")
    public ResponseEntity<List<FligthXAirportDTO>> getFligthXAirport(){

        return ResponseEntity.ok(fligthXAirportService.getFligthXAirport());
    }

    @PostMapping("/")
    public ResponseEntity<FligthXAirportDTO> createFligthXAirport(@Valid @RequestBody FligthXAirportDTO fligthXAirportDTO) {

        FligthXAirportDTO newFligthXAirport = fligthXAirportService.addFligthXAirport(fligthXAirportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFligthXAirport);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<FligthXAirportDTO>> findFligthXAirportById(@PathVariable String id){
        return ResponseEntity.ok(fligthXAirportService.getFligthXAirportById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFligthXAirport(@PathVariable String id){
        fligthXAirportService.deleteFligthXAirportById(id);
        return ResponseEntity.noContent().build();
    }
}

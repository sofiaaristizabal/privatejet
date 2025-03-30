package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.FligthXAirportDTO;
import com.app.privatejet.servicios.IFligthXAirportService;
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
@RequestMapping("/api/FligthXAirport")
@Tag(name = "FligthXAirport controller", description = "Manage FligthXAirport operations" )
public class FligthXAirportController {

    @Autowired
    private IFligthXAirportService fligthXAirportService;

    @GetMapping("/")
    @Operation(summary = "Get a FligthXAirport", description = "Retrieves a list of all FligthXAirport.")
    public ResponseEntity<List<FligthXAirportDTO>> getFligthXAirport(){

        return ResponseEntity.ok(fligthXAirportService.getFligthXAirport());
    }

    @PostMapping("/")
    @Operation(summary = "Create a FligthXAirport", description = "Add a new FligthXAirport to the repository")
    public ResponseEntity<FligthXAirportDTO> createFligthXAirport(@Valid @RequestBody FligthXAirportDTO fligthXAirportDTO) {

        FligthXAirportDTO newFligthXAirport = fligthXAirportService.addFligthXAirport(fligthXAirportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFligthXAirport);
    }

    @GetMapping("/findId/{id}")
    @Operation(summary = "find FligthXAirport by Id", description = "find a FligthXAirport from the repository by it's Id")
    public ResponseEntity<Optional<FligthXAirportDTO>> findFligthXAirportById(@PathVariable String id){
        return ResponseEntity.ok(fligthXAirportService.getFligthXAirportById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a FligthXAirport", description = "Delete a FligthXAirport by it's Id from repository")
    public ResponseEntity<Void> deleteFligthXAirport(@PathVariable String id){
        fligthXAirportService.deleteFligthXAirportById(id);
        return ResponseEntity.noContent().build();
    }
}

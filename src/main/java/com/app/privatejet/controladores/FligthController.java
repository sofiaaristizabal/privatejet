package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.FligthDTO;
import com.app.privatejet.servicios.IFligthService;
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
@RequestMapping("/api/fligth")
@Tag(name = "Flight controller", description = "Manage flight operations" )
public class FligthController {

    @Autowired
    private IFligthService fligthService;

    @GetMapping("/")
    @Operation(summary = "Get flights", description = "Retrieves a list of all flights.")
    public ResponseEntity<List<FligthDTO>> getFligths(){

        return ResponseEntity.ok(fligthService.getFligths());
    }

    @PostMapping("/")
    @Operation(summary = "Create a flight", description = "Add a new flight to the repository")
    public ResponseEntity<FligthDTO> createFligth(@Valid @RequestBody FligthDTO fligthDTO) {

        FligthDTO newFligth = fligthService.addFligth(fligthDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFligth);
    }

    @GetMapping("/findId/{id}")
    @Operation(summary = "find flight by Id", description = "find a flight from the repository by it's Id")
    public ResponseEntity<Optional<FligthDTO>> findFligthById(@PathVariable String id){
        return ResponseEntity.ok(fligthService.getFligthById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a flight", description = "Delete a flight by it's Id from repository")
    public ResponseEntity<Void> deleteFligth(@PathVariable String id){
        fligthService.deleteFligthById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.CelebrityDTO;
import com.app.privatejet.servicios.ICelebrityService;
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
@RequestMapping("/api/celebrity")
@Tag(name = "Celebrity controller", description = "Manage celebrity operations" )
public class CelebrityController {

    @Autowired
    private ICelebrityService celebrityService;

    @GetMapping("/")
    @Operation(summary = "Get a celebrities", description = "Retrieves a list of all celebrities.")
    public ResponseEntity<List<CelebrityDTO>> getCelebrities(){
        return ResponseEntity.ok(celebrityService.getCelebrities());
    }

    @PostMapping("/")
    @Operation(summary = "Create a celebrity", description = "Add a new celebrity to the repository")
    public ResponseEntity<CelebrityDTO> createCelebrity(@Valid @RequestBody CelebrityDTO celebrityDTO) {

       CelebrityDTO newCelebrity = celebrityService.addCelebrity(celebrityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCelebrity);
    }

    @GetMapping("/findId/{id}")
    @Operation(summary = "find celebrity by Id", description = "find a celebrity from the repository by it's Id")
    public ResponseEntity<Optional<CelebrityDTO>> findCelebrityById(@PathVariable String id){
        return ResponseEntity.ok(celebrityService.getCelebrityById(id));
    }

    @GetMapping("/findName/{name}")
    @Operation(summary = "Find a celebrity by name", description = "Find a celebrity from the repository by its name")
    public ResponseEntity<Optional<CelebrityDTO>> findCelebrityByName(@PathVariable String name){
        return ResponseEntity.ok(celebrityService.getCelebrityByName(name));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a celebrity", description = "Delete a celebrity by it's Id from repository")
    public ResponseEntity<Void> deleteCelebrity(@PathVariable String id){
        celebrityService.deleteCelebrityById(id);
        return ResponseEntity.noContent().build();
    }
}

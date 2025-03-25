package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.CelebrityDTO;
import com.app.privatejet.servicios.ICelebrityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/celebrity")
public class CelebrityController {

    @Autowired
    private ICelebrityService celebrityService;

    @GetMapping("/")
    public ResponseEntity<List<CelebrityDTO>> getCelebrities(){
        return ResponseEntity.ok(celebrityService.getCelebrities());
    }

    @PostMapping("/")
    public ResponseEntity<CelebrityDTO> createCelebrity(@Valid @RequestBody CelebrityDTO celebrityDTO) {

       CelebrityDTO newCelebrity = celebrityService.addCelebrity(celebrityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCelebrity);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<CelebrityDTO>> findCelebrityById(@PathVariable String id){
        return ResponseEntity.ok(celebrityService.getCelebrityById(id));
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<Optional<CelebrityDTO>> findCelebrityByName(@PathVariable String name){
        return ResponseEntity.ok(celebrityService.getCelebrityByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelebrity(@PathVariable String id){
        celebrityService.deleteCelebrityById(id);
        return ResponseEntity.noContent().build();
    }
}

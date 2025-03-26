package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.FligthDTO;
import com.app.privatejet.servicios.IFligthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fligth")
public class FligthController {

    @Autowired
    private IFligthService fligthService;

    @GetMapping("/")
    public ResponseEntity<List<FligthDTO>> getFligths(){

        return ResponseEntity.ok(fligthService.getFligths());
    }

    @PostMapping("/")
    public ResponseEntity<FligthDTO> createFligth(@Valid @RequestBody FligthDTO fligthDTO) {

        FligthDTO newFligth = fligthService.addFligth(fligthDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFligth);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<FligthDTO>> findFligthById(@PathVariable String id){
        return ResponseEntity.ok(fligthService.getFligthById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFligth(@PathVariable String id){
        fligthService.deleteFligthById(id);
        return ResponseEntity.noContent().build();
    }
}
